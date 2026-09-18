class Node:
    def __init__(self,val,next=None,prev=None):
        self.val=val
        self.next=next
        self.prev=prev

class MyCircularQueue:

    def __init__(self, k: int):
        self.count=0
        self.k=k
        self.dummy=Node(-1)
        self.dummy.next=self.dummy
        self.dummy.prev=self.dummy

    def enQueue(self, value: int) -> bool:
        if self.count==self.k:
            return False
        
        newnode=Node(value)

        tail=self.dummy.prev
        tail.next=newnode
        newnode.next=self.dummy
        newnode.prev=tail
        self.dummy.prev=newnode

        self.count+=1
        return True

    def deQueue(self) -> bool:
        if self.count==0:
            return False
        
        front=self.dummy.next
        self.dummy.next=front.next
        front.next.prev=self.dummy
        self.count-=1
        return True

    def Front(self) -> int:
        if self.count==0:
            return -1
        
        return self.dummy.next.val

    def Rear(self) -> int:
        if self.count==0:
            return -1
        
        return self.dummy.prev.val

    def isEmpty(self) -> bool:
        return self.count==0

    def isFull(self) -> bool:
        return self.count==self.k


# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()