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
    int maxDia=0;
    public int Diameter(TreeNode root){
        if(root==null) return 0;
        int a=Diameter(root.left);
        int b=Diameter(root.right);
        maxDia=Math.max(maxDia,a+b);
        return 1+Math.max(a,b);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Diameter(root);
        return maxDia;
    }
}
