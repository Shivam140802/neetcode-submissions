class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(a->a[1]));
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        int currPass=0;
        for(int[] trip:trips){
            int numPass=trip[0], start=trip[1], end=trip[2];
            while(!pq.isEmpty() && pq.peek()[0]<=start){
                currPass-=pq.poll()[1];
            }
            currPass+=numPass;
            if(currPass>capacity){
                return false;
            }
            pq.offer(new int[]{end, numPass});
        }
        return true;
    }
}