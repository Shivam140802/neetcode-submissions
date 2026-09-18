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
    int count=0, res=0;
    public void small(TreeNode root, int k){
        if(root==null) return;
        small(root.left,k);
        count+=1;
        if(k==count) {
            res=root.val;
            return;
        }
        small(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        small(root,k);
        return res;
    }
}
