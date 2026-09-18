class Solution {
    int[][] direction={{-1,0},{0,1},{1,0},{0,-1}};
    public void dfs(int[][] grid, int[][] vis, int i, int j, int n, int m, int[] res){
        vis[i][j]=1;
        for(int[] dir:direction){
            int new_i=i+dir[0];
            int new_j=j+dir[1];
            if(new_i>=0 && new_j>=0 && new_i<n && new_j<m && vis[new_i][new_j]==0 && grid[new_i][new_j]==1){
                res[0]+=1;
                dfs(grid, vis, new_i, new_j, n, m, res);
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int[] res=new int[1];
        int max_res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    res[0]=1;
                    dfs(grid, vis, i, j, n, m, res);
                    max_res=Math.max(max_res, res[0]);
                }
            }
        }
        return max_res;
    }
}
