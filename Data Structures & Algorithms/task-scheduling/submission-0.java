class Solution {
    class Pair{
        int count;
        char ch;
        Pair(int count, char ch){
            this.count=count;
            this.ch=ch;
        }
        public int getcount(){
            return count;
        }
        public char getChar(){
            return ch;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparingInt(Pair::getcount).reversed());
        HashMap<Character, Integer> map=new HashMap<>();
        for(char ch:tasks){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for(Map.Entry<Character, Integer> entry:map.entrySet()){
            pq.offer(new Pair(entry.getValue(), entry.getKey()));
        }
        int result=0;
        while(!pq.isEmpty()){
            List<Pair> list=new ArrayList<>();
            int cycle=n+1;
            while(cycle>0 && !pq.isEmpty()){
                Pair current=pq.poll();
                if(current.getcount()>1){
                    list.add(new Pair(current.getcount()-1,current.getChar()));
                }
                result+=1;
                cycle-=1;

            }
            for(Pair p:list){
                pq.offer(p);
            }
            if(!pq.isEmpty()){
                result+=cycle;
            }
        }
        return result;
    }
}
