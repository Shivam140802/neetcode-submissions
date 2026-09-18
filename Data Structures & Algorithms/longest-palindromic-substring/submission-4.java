class Solution {
    public int Pallin(String st, int i ,int j){
        while(i>=0 && j<st.length() && st.charAt(i)==st.charAt(j)){
            i-=1;
            j+=1;
        }
        return j-i-1;
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==0) return "";
        int start=0, end=0;
        for(int i=0;i<n;i++){
            int len1=Pallin(s, i, i);
            int len2=Pallin(s, i, i+1);
            int len=Math.max(len1, len2);
            if(len>end-start+1){
                start=i-(len-1)/2;
                end=i+(len)/2;
            }
        }
        return s.substring(start, end+1);
    }
}
