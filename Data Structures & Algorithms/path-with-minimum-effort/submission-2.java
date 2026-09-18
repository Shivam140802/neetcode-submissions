class Solution {
    int[][] direction={{-1,0},{0,1},{1,0},{0,-1}};
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] dist=new int[n][m];
        for(int[] d:dist){
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int[]{0,0,0});
        int min_effort=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int i=curr[1];
            int j=curr[2];
            int diff=curr[0];
            if(i==n-1 && j==m-1) return diff;
            if(dist[i][j]<diff) continue;
            for(int[] dir:direction){
                int new_i=i+dir[0];
                int new_j=j+dir[1];
                if(new_i>=0 && new_j>=0 && new_i<n && new_j<m){
                    int new_diff=Math.max(diff,Math.abs(heights[i][j]-heights[new_i][new_j]));
                    if(new_diff<dist[new_i][new_j]){
                        dist[new_i][new_j]=new_diff;
                        pq.offer(new int[]{new_diff, new_i, new_j});
                    }
                }
            }
        }
        return min_effort;
    }
}