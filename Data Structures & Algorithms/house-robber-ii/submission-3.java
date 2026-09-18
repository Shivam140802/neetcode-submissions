class Solution {
    public int Max1(int[] nums, int idx, int[] dp){
        if(idx>=nums.length-1) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int first=nums[idx]+Max1(nums, idx+2, dp);
        int second=Max1(nums, idx+1, dp);
        return dp[idx]=Math.max(first, second);
    }
    public int Max2(int[] nums, int idx, int[] dp){
        if(idx>=nums.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int first=nums[idx]+Max2(nums, idx+2, dp);
        int second=Max2(nums, idx+1, dp);
        return dp[idx]=Math.max(first, second);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp1=new int[n];
        Arrays.fill(dp1, -1);
        int[] dp2=new int[n];
        Arrays.fill(dp2, -1);
        return Math.max(Max1(nums, 0, dp1),Max2(nums, 1, dp2));
    }
}
