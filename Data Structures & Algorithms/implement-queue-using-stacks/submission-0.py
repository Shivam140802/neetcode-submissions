class MyQueue:

    def __init__(self):
        self.stack1=[]
        self.stack2=[]

    def push(self, x: int) -> None:
        self.stack1.append(x)

    def pop(self) -> int:
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        pop_ele=self.stack2.pop()
        return pop_ele
        
    def peek(self) -> int:
        num=self.pop()
        self.stack2.append(num)
        return num

    def empty(self) -> bool:
        return True if len(self.stack1)==0 and len(self.stack2)==0 else False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()