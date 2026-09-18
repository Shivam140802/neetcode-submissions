# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        count=right-left+1
        dummy=ListNode(-1)
        dummy.next=head
        temp=dummy
        left_prev=None
        while left>0:
            left_prev=temp
            temp=temp.next
            left-=1
        prev_node=None
        curr_node=temp
        while count>0:
            next_node=curr_node.next
            curr_node.next=prev_node
            prev_node=curr_node
            curr_node=next_node
            count-=1
        
        left_prev.next=prev_node
        temp.next=curr_node

        return dummy.next