class KthLargest {
    PriorityQueue<Integer> pq;
    int k=0;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>(Collections.reverseOrder());
        this.k=k;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
    }
    public int Extract(PriorityQueue<Integer> pq, int i,int k){
        if(i==k){
            return pq.peek();
        }
        int add=pq.poll();
        int num=Extract(pq,i+1,k);
        pq.offer(add);
        return num;
    }
    public int add(int val) {
        pq.add(val);
        return Extract(pq,1,k);
    }
}
