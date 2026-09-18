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
    boolean isbalance=true;
    public int Diff(TreeNode root){
        if(root==null) return 0;
        int a=1+Diff(root.left);
        int b=1+Diff(root.right);
        if(Math.abs(a-b)>1) isbalance=false;
        return Math.max(a,b);
    }
    public boolean isBalanced(TreeNode root) {
        Diff(root);
        return isbalance;
    }
}
