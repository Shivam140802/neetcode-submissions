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
    int sum=Integer.MIN_VALUE;
    public int find_sum(TreeNode root){
        if(root==null) return 0;
        int left_sum=find_sum(root.left);
        int right_sum=find_sum(root.right);
        
        int all_good=root.val+left_sum+right_sum;
        int only_one=Math.max(left_sum,right_sum)+root.val;
        int only_root=root.val;
        sum=Math.max(Math.max(sum, all_good),Math.max(only_one, only_root));
        return Math.max(only_one, only_root);
    }
    public int maxPathSum(TreeNode root) {
        find_sum(root);
        return sum;
    }
}
