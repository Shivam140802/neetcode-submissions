/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int count=0;
    public void find_good(TreeNode root,int maxVal){
        if(root==null) return;
        if(root.val>=maxVal){
            count+=1;
        }
        find_good(root.left,Math.max(maxVal,root.val));
        find_good(root.right,Math.max(maxVal,root.val));
    }
    public int goodNodes(TreeNode root) {
        find_good(root,-101);
        return count;
    }
}
