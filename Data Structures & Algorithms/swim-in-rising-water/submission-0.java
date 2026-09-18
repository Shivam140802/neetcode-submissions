class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dist=new int[n][m];
        for(int[] arr:dist){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{grid[0][0],0,0});
        dist[0][0]=0;
        int[][] direction={{-1,0},{0,1},{1,0},{0,-1}};
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int time=arr[0];
            int row=arr[1];
            int col=arr[2];
            if(row==n-1 && col==m-1) return dist[n-1][m-1];
            for(int[] dir:direction){
                int new_row=row+dir[0];
                int new_col=col+dir[1];
                if(new_row>=0 && new_col>=0 && new_row<n && new_col<m){
                    int new_time=Math.max(time, grid[new_row][new_col]);
                    if(new_time<dist[new_row][new_col]){
                        pq.offer(new int[]{new_time, new_row, new_col});
                        dist[new_row][new_col]=new_time;
                    }
                }
            }
        } 
        return -1;
    }
}
