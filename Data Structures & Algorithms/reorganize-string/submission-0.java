class Solution {
    class Pair{
        int count;
        char ch;
        Pair(int count, char ch){
            this.count=count;
            this.ch=ch;
        }
        int getCount(){
            return count;
        }
        char getChar(){
            return ch;
        }
    }
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int max_len=0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            max_len=Math.max(max_len, map.get(s.charAt(i)));
        }
        if(max_len>(s.length()+1)/2) return "";
        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparingInt(Pair::getCount).reversed());
        for(Map.Entry<Character, Integer> entry:map.entrySet()){
            pq.offer(new Pair(entry.getValue(), entry.getKey()));
        }
        char[] ch=new char[s.length()];
        int i=0;
        while(!pq.isEmpty()){
            Pair obj=pq.poll();
            char c=obj.getChar();
            int count=obj.getCount();
            while(count>0){
                if(i>=s.length()){
                    i=1;
                }
                ch[i]=c;
                i+=2;
                count-=1;
            }
        }
        return String.valueOf(ch);
    }
}