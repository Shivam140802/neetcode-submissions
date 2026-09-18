# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverse(self,back,forw):
        if forw is None:
            return back
        head=self.reverse(back.next,forw.next if forw else None)
        forw.next=back
        back.next=None
        return head

    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head or not head.next or not head.next.next:
            return
        
        slow=head
        fast=head
        prev=None
        while fast and fast.next:
            prev=slow
            slow=slow.next
            fast=fast.next.next
        
        prev.next=None

        head2=self.reverse(slow,slow.next if slow else None)
        
        head1=head
        
        while head1 and head2:
            temp1=head1.next
            temp2=head2.next
            
            head1.next=head2
            if temp1:
                head2.next=temp1

            head1=temp1
            head2=temp2
        