/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        int n=grid.length;
        boolean same=true;
        int firstVal=grid[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=firstVal){
                    same=false;
                    break;
                }
            }
        }
        if(same) return new Node(firstVal==1, true);
        
        int half=n/2;
        int[][] topLeftArr=new int[half][half];
        int[][] topRightArr=new int[half][half];
        int[][] bottomLeftArr=new int[half][half];
        int[][] bottomRightArr=new int[half][half];
        for(int i=0;i<half;i++){
            for(int j=0;j<half;j++){
                topLeftArr[i][j]=grid[i][j];
                topRightArr[i][j]=grid[i][j+half];
                bottomLeftArr[i][j]=grid[i+half][j];
                bottomRightArr[i][j]=grid[i+half][j+half];
            }
        }
        Node topLeft=construct(topLeftArr);
        Node topRight=construct(topRightArr);
        Node bottomLeft=construct(bottomLeftArr);
        Node bottomRight=construct(bottomRightArr);

        return new Node(false,false, topLeft,topRight, bottomLeft, bottomRight);

    }
}