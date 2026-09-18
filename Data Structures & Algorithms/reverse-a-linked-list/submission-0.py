# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverse(self,back,forw):
        if forw is None:
            return back
        head=self.reverse(back.next,forw.next)
        forw.next=back
        back.next=None
        return head
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head
        return self.reverse(head,head.next)