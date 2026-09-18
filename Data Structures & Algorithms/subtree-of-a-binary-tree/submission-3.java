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
    boolean isSub=false;
    public boolean same(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if(p==null) return false;
        if(q==null) return false;
        return (p.val==q.val) && same(p.left,q.left) && same(p.right,q.right); 
    }
    public void sub(TreeNode p, TreeNode q){
        if(p==null) return;
        if(same(p,q)){
            isSub=true;
            return;
        }
        sub(p.left,q);
        sub(p.right,q);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        sub(root,subRoot);
        return isSub;
    }
}
