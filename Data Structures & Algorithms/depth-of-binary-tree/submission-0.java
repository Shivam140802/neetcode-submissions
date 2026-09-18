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
    public int Depth(TreeNode root){
        if(root==null) return 0;
        int a=1+Depth(root.left);
        int b=1+Depth(root.right);
        return Math.max(a,b);
    }
    public int maxDepth(TreeNode root) {
        return Depth(root);
    }
}
