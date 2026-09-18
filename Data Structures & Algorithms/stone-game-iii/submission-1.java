class Solution {
    int[] dp;
    public int Stone(int[] nums, int idx, int n){
        if(idx>=n) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int take1=nums[idx]-Stone(nums, idx+1, n);
        
        int take2=Integer.MIN_VALUE;
        if(idx+1<n)
        take2=nums[idx]+nums[idx+1]-Stone(nums, idx+2, n);
        
        int take3=Integer.MIN_VALUE;
        if(idx+2<n)
        take3=nums[idx]+nums[idx+1]+nums[idx+2]-Stone(nums, idx+3, n);

        return dp[idx]=Math.max(take1, Math.max(take2, take3));
    }
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        dp=new int[n];
        Arrays.fill(dp, -1);
        int num=Stone(stoneValue, 0, n);
        if(num==0) return "Tie";
        else if(num>0) return "Alice";
        else return "Bob";
    }
}