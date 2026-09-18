class Solution {
    int[][] dp;
    public int Unique(int[][] nums, int i, int j, int m, int n){
        if(i>=m || j>=n) return Integer.MAX_VALUE;
        if(i==m-1 && j==n-1) return nums[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int num1=Unique(nums, i+1, j, m, n);
        int num2=Unique(nums, i, j+1, m, n);
        return dp[i][j]=nums[i][j]+Math.min(num1, num2);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        dp=new int[m][n];
        for(int[] arr:dp) Arrays.fill(arr, -1);
        return Unique(grid, 0, 0, m, n);
    }
}