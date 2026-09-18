class Solution {
    public boolean Sum(int[] nums, int idx, int sum, int target){
        if(idx==nums.length) return false;
        if(sum==target) return true;
        
        return Sum(nums, idx+1, sum+nums[idx], target) || Sum(nums, idx+1, sum, target);
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        sum=sum/2;
        return Sum(nums, 0, 0, sum);  
    }
}
