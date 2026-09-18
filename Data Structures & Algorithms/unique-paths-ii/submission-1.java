class Solution {
    int[][] dp;
    public int Unique(int[][] nums, int i, int j, int m, int n){
        if(i>=m || j>=n) return 0;
        if(nums[i][j]==1) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];

        return dp[i][j]=Unique(nums, i+1, j, m, n)+Unique(nums, i, j+1, m, n);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        dp=new int[m][n];
        for(int[] arr:dp) Arrays.fill(arr, -1);
        return Unique(obstacleGrid, 0, 0, m, n);
    }
}