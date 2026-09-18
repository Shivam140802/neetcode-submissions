class Solution {
    int[] dp;
    public int Combo(int curr, int target){
        if(curr>target) return Integer.MAX_VALUE;
        if(curr==target) return 0;
        if(dp[curr]!=-1) return dp[curr];
        int count=Integer.MAX_VALUE;
        for(int i=1;i*i<=target;i++){
            int next=Combo(curr+(i*i), target);
            if(next!=Integer.MAX_VALUE){
                count=Math.min(count, 1+next);
            }
        }
        return dp[curr]=count;
    }
    public int numSquares(int n) {
        dp=new int[n+1];
        Arrays.fill(dp, -1);
        return Combo(0, n);
    }
}