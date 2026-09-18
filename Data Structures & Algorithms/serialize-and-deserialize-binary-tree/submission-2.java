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

public class Codec {
    // Encodes a tree to a single string.
    StringBuilder sb=new StringBuilder();
    int ind=0;
    public void Serial(TreeNode root){
        if(root==null){
            sb.append('*').append(',');
            return;
        }
        sb.append(root.val).append(',');
        Serial(root.left);
        Serial(root.right);
    }
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Serial(root);
        return sb.toString();
        
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ind=0;
        return DeSerial(data);
    }
    public TreeNode DeSerial(String data){
        if(ind>=data.length()) return null;
        if(data.charAt(ind)=='*'){
            ind+=2;
            return null;
        }
        int num=0;
        boolean negative=false;
        if(data.charAt(ind)=='-'){
            negative=true;
            ind+=1;
        }
        while(ind<data.length() && data.charAt(ind)!=','){
            num=num*10+(data.charAt(ind)-'0');
            ind+=1;
        }
        ind+=1;
        if(negative) num=-num;
        TreeNode root=new TreeNode(num);
        root.left=DeSerial(data);
        root.right=DeSerial(data);
        return root;
    }
}
