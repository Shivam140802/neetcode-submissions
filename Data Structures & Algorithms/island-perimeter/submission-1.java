class Solution {
    int[][] direction={{-1,0},{0,1},{1,0},{0,-1}};
    int res=0;
    public void dfs(int[][] grid, int[][] vis, int x, int y, int row, int col){
        int count=0;
        for(int[] dir:direction){
            int i=x+dir[0];
            int j=y+dir[1];
            if(i<0 || j<0 || i==row || j==col || grid[i][j]==0){
                count+=1;
            }
        }
        res+=count;
        vis[x][y]=1;
        for(int[] dir:direction){
            int i=x+dir[0];
            int j=y+dir[1];
            if(i>=0 && j>=0 && i<row && j<col && vis[i][j]==0 && grid[i][j]==1){
                dfs(grid, vis, i, j, row, col);
            }
        }
    }
    public int islandPerimeter(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][] vis=new int[row][col];
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    dfs(grid, vis, i, j, row, col);
                    break;
                }
            }
        }
        return res;
    }
}