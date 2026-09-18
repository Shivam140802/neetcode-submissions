class Solution {
    class Pair{
        String st;
        int len;
        Pair(String st, int len){
            this.st=st;
            this.len=len;
        }
        int max_len(){
            return len;
        }
    }
    public boolean check(String st){
        int i=0, j=st.length()-1;
        while(i<j){
            if(st.charAt(i)!=st.charAt(j)) return false;
            i+=1;
            j-=1;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparingInt(Pair::max_len).reversed());
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                String st=s.substring(i,j);
                if(check(st))
                    pq.offer(new Pair(st, st.length()));
            }
        }
        return pq.poll().st;
    }
}
