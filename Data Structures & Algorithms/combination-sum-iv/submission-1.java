class Solution {
    int[] dp;
    public int Combo(int[] nums, int sum, int target){
        if(sum==target) return 1;
        if(sum>target) return 0;
        if(dp[sum]!=-1) return dp[sum];
        int count=0;
        for(int i=0;i<nums.length;i++){
            count+=Combo(nums, sum+nums[i], target);
        }
        return dp[sum]=count;
    }
    public int combinationSum4(int[] nums, int target) {
        dp=new int[target+1];
        Arrays.fill(dp, -1);
        return Combo(nums, 0, target);
    }
}