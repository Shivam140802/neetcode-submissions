class Solution {
    Boolean[] dp;
    public boolean Word(String s,int idx, HashSet<String> set){
        if(idx==s.length()) return true;
        if(dp[idx]!=null) return dp[idx];
        for(int i=idx;i<s.length();i++){
            String st=s.substring(idx, i+1);
            if(set.contains(st) && Word(s, i+1, set)){
                return dp[idx]=true;
            }
        }
        return dp[idx]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>(wordDict);
        dp=new Boolean[s.length()];
        return Word(s, 0, set);   
    }
}
