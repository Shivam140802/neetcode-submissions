class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] direction={{-1,0}, {0,1}, {1,0}, {0,-1}};
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh+=1;
                }
            }
        }
        if(fresh==0) return 0;
        int count=-1;
        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                int[] cell=q.poll();
                int row=cell[0];
                int col=cell[1];
                for(int[] dir: direction){
                    int new_row=row+dir[0];
                    int new_col=col+dir[1];
                    if(new_row>=0 && new_col>=0 && new_row<n && new_col<m && grid[new_row][new_col]==1){
                        grid[new_row][new_col]=2;
                        q.offer(new int[]{new_row, new_col});
                        fresh-=1;
                    }
                }
            }
            count+=1;
        }
        return fresh==0?count:-1;
    }
}
