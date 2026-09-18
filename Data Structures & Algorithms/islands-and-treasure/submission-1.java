class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] direction={{-1,0},{0,1},{1,0},{0,-1}};
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] cell=q.poll();
            int row=cell[0], col=cell[1];
            for(int[] dir:direction){
                int new_row=row+dir[0];
                int new_col=col+dir[1];
                if(new_row>=0 && new_col>=0 && new_row<n && new_col<m && grid[new_row][new_col]==Integer.MAX_VALUE){
                    grid[new_row][new_col]=grid[row][col]+1;
                    q.offer(new int[]{new_row, new_col});
                }
            }
        }
    }
}
