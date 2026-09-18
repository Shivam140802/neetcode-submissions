"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        temp=head
        while temp:
            new_node=Node(temp.val)
            new_node.next=temp.next
            temp.next=new_node
            temp=new_node.next
        
        temp=head
        while temp:
            if temp.random:
                temp.next.random=temp.random.next
            temp=temp.next.next
        
        copy_head=head.next
        temp=head
        copy=copy_head
        while temp:
            temp.next=temp.next.next
            if copy.next:
                copy.next=copy.next.next
            copy=copy.next
            temp=temp.next
        return copy_head