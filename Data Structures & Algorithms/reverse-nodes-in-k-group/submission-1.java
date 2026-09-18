/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public List<ListNode> reverse(ListNode head,int k){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=null;
        while(k-->0){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ArrayList<ListNode> list=new ArrayList<>();
        list.add(prev);
        list.add(curr);
        return list;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count+=1;
        }

        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy,curr=head;
        while(count>=k){
            ListNode tail=curr;
            List<ListNode> list=new ArrayList<>();
            list.addAll(reverse(curr,k));
            prev.next=list.get(0);
            tail.next=list.get(1);
            prev=tail;
            curr=list.get(1);
            count-=k;
        }
        return dummy.next;
    }
}
