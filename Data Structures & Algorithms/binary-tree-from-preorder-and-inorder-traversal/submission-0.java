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
    int preorder_idx=0;
    public TreeNode Build(int[] preorder,int[] inorder, HashMap<Integer,Integer> map,int l, int r){
        if(l>r) return null;
        int rootVal=preorder[preorder_idx++];
        TreeNode root=new TreeNode(rootVal);
        root.left=Build(preorder,inorder,map,l,map.get(rootVal)-1);
        root.right=Build(preorder, inorder, map,map.get(rootVal)+1,r);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return Build(preorder,inorder,map,0,inorder.length-1);
    }
}
