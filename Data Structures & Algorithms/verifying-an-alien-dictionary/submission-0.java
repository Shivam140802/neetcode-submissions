class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        for(int i=1;i<words.length;i++){
            String w1=words[i-1], w2=words[i];
            int len=Math.min(w1.length(), w2.length());
            boolean flag=false;
            for(int j=0;j<len;j++){
                char ch1=w1.charAt(j), ch2=w2.charAt(j);
                if(map.get(ch1)<map.get(ch2)){
                    flag=true;
                    break;
                }
                else if(map.get(ch1)>map.get(ch2)){
                    return false;
                }
            }
            if(!flag && w1.length()>w2.length()) return false;
        }
        return true;
    }
}