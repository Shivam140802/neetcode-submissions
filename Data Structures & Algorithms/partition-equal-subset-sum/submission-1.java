class Solution {
    Boolean[][] dp;
    public boolean Sum(int[] nums, int idx, int sum, int target){
        if(sum==target) return true;
        if(idx==nums.length || sum>target) return false;
        if(dp[idx][sum]!=null) return dp[idx][sum];
        return dp[idx][sum]=Sum(nums, idx+1, sum+nums[idx], target) || Sum(nums, idx+1, sum, target);
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        dp=new Boolean[nums.length][target+1];
        return Sum(nums, 0, 0, target);  
    }
}
