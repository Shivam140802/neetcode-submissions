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
    public void Remove(TreeNode root, int target, TreeNode prev_ptr, boolean left, boolean right){
        if(root==null) return;
        Remove(root.left,target, root, true, false);
        Remove(root.right,target, root, false, true);
        if(root.left==null && root.right==null && root.val==target && left){
            prev_ptr.left=null;
        }
        if(root.left==null && root.right==null && root.val==target && right){
            prev_ptr.right=null;
        }
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null) return null;
        if(root.left==null && root.right==null) return null;
        TreeNode dummy=new TreeNode(-1);
        dummy.left=root;
        dummy.right=null;
        Remove(root,target, dummy, true, false);
        return dummy.left;
    }
}