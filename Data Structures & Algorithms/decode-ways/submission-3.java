class Solution {
    int[] dp;
    public int All(String s, int idx, int n){
        if(idx>=n) return 1;
        if(s.charAt(idx)=='0') return 0;
        if(dp[idx]!=-1) return dp[idx];
        int result=All(s, idx+1, n);
        if(idx+1<n){
            if(s.charAt(idx)=='1' || (s.charAt(idx)=='2' && s.charAt(idx+1)<='6'))
                result+= All(s, idx+2, n);
        }
        return dp[idx]=result;
    }
    public int numDecodings(String s) {
        int n=s.length();
        dp=new int[n];
        Arrays.fill(dp, -1);
        return All(s, 0, n);
    }
}
