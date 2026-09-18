class Solution {
    public boolean Part(int[] nums, int target, boolean[] used, int CurrSum, int idx, int k){
       
        if(k==0) return true;
        if(CurrSum==target){
            return Part(nums, target, used, 0, 0, k-1);
        }

        for(int i=idx;i<nums.length;i++){
            if(!used[i] && CurrSum+nums[i]<=target){
                used[i]=true;
                if(Part(nums, target, used, CurrSum+nums[i], idx+1, k)) return true;
                used[i]=false;
            }
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int num:nums) sum+=num;
        if(sum%k!=0) return false;
        int target=sum/k;
        boolean[] used=new boolean[nums.length];
        return Part(nums, target, used, 0, 0, k);
    }
}