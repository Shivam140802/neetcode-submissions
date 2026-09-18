class Solution {
    int[][] direction={{-1,0},{0,1},{1,0},{0,-1}};
    int n,m;
    public void dfs(int[][] heights, boolean[][] vis, int prev, int i, int j){
        if(i<0 || j<0 || i==n || j==m || vis[i][j] || heights[i][j]<prev) return;
        vis[i][j]=true;
        for(int[] dir:direction){
            dfs(heights, vis, heights[i][j], i+dir[0], j+dir[1]);
        }
    }  
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n=heights.length;
        m=heights[0].length;
        boolean[][] pacific=new boolean[n][m];
        boolean[][] atlantic=new boolean[n][m];
        for(int i=0;i<n;i++){
            dfs(heights, pacific, heights[i][0], i, 0);
            dfs(heights, atlantic, heights[i][m-1], i, m-1);
        }
        for(int i=0;i<m;i++){
            dfs(heights, pacific, heights[0][i], 0, i);
            dfs(heights, atlantic, heights[n-1][i], n-1, i);
        }
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]) list.add(Arrays.asList(i,j));
            }
        }
        return list;
    }
}
