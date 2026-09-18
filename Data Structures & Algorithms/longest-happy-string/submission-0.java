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
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> maxHeap=new PriorityQueue<>(Comparator.comparingInt(Pair::getCount).reversed());
        if(a>0) maxHeap.offer(new Pair(a,'a'));
        if(b>0) maxHeap.offer(new Pair(b,'b'));  
        if(c>0) maxHeap.offer(new Pair(c,'c'));
        StringBuilder sb=new StringBuilder();
        while(!maxHeap.isEmpty()){
            Pair first=maxHeap.poll();
            if(sb.length()>1 && first.getChar()==sb.charAt(sb.length()-1) && first.getChar()==sb.charAt(sb.length()-2)){
                if(maxHeap.isEmpty()) break;
                Pair second=maxHeap.poll();
                sb.append(second.getChar());
                if(second.getCount()>1){
                    maxHeap.offer(new Pair(second.getCount()-1, second.getChar()));
                }
                maxHeap.offer(first);
            }
            else{
                sb.append(first.getChar());
                if(first.getCount()>1){
                    maxHeap.offer(new Pair(first.getCount()-1, first.getChar()));
                }
            }
        }
        return sb.toString();
    }
}