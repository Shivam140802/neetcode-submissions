class Solution {
    int[] dp;
    public int Break(int n){
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        int product=0;
        for(int i=1;i<=n;i++){
            int choice= Math.max(n-i, Break(n-i));
            product=Math.max(product, i*choice);
        }
        return dp[n]=product;
    }

    public int integerBreak(int n) {
        dp=new int[n+1];
        Arrays.fill(dp, -1);
        return Break(n);
    }
}