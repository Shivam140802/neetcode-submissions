class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:stones){
            pq.offer(num);
        }   
        while(pq.size()>1){
            int x=pq.poll();
            int y=pq.poll();
            pq.offer(Math.abs(x-y));
        }
        return pq.peek();
    }
}
