# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        if not head.next and n==1:
            return None 
        dummy=ListNode(-1)
        dummy.next=head
        temp=dummy
        count=-1
        while temp:
            temp=temp.next
            count+=1
        count=count-n
        temp=dummy
        while count>0:
            temp=temp.next
            count-=1
        
        if temp.next.next:
            temp.next=temp.next.next
        else:
            temp.next=None
  
        return dummy.next