class Solution {
    public int All(String s, int idx, int n){
        if(idx>=n) return 1;
        if(s.charAt(idx)=='0') return 0;
        int result=All(s, idx+1, n);
        if(idx+1<n){
            if(s.charAt(idx)=='1' || (s.charAt(idx)=='2' && s.charAt(idx+1)<='6'))
            result+= All(s, idx+2, n);
        }
        return result;

    }
    public int numDecodings(String s) {
        int n=s.length();
        return All(s, 0, n);
    }
}
