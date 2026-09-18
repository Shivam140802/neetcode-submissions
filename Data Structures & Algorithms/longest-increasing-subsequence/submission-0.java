class Solution {
    public int LIS(int[] nums, int idx, int prev_idx){
        if(idx==nums.length) return 0;
        int len=LIS(nums, idx+1, prev_idx);
        if(prev_idx==-1 || nums[idx]>nums[prev_idx]){
            len=Math.max(len,1+LIS(nums, idx+1, idx));
        }
        return len;
    }
    public int lengthOfLIS(int[] nums) {
        return LIS(nums, 0, -1);
    }
}
