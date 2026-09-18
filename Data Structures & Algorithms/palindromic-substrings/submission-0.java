class Solution {
    public int Pallin(String st, int i ,int j){
        int count=0;
        while(i>=0 && j<st.length() && st.charAt(i)==st.charAt(j)){
            count+=1;
            i-=1;
            j+=1;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int n=s.length();
        int start=0, end=0;
        int count=0;
        for(int i=0;i<n;i++){
            count+=Pallin(s, i, i);
            count+=Pallin(s, i, i+1);
        }
        return count;
    }
}
