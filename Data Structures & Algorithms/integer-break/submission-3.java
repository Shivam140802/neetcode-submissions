class Solution {
    int[] dp;
    public int Break(int n){
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        int result=0;
        for(int i=1;i<n;i++){
            int product= i * Math.max((n-i), Break(n-i));
            result=Math.max(result, product);
        }
        return dp[n]=result;
    }

    public int integerBreak(int n) {
        dp=new int[n+1];
        Arrays.fill(dp, -1);
        return Break(n);
    }
}