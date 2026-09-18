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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode node=lists[i];
            while(node!=null){
                list.add(node.val);
                node=node.next;
            }
        }
        Collections.sort(list);
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        for(int num:list){
            ListNode node=new ListNode(num);
            temp.next=node;
            temp=temp.next;
        }
        return dummy.next;
    }
}
