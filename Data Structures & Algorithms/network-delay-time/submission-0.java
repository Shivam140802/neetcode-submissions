class Solution {
    class Pair{
        int node, weight;
        Pair(int node, int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:times){
            int ui=arr[0];
            int vi=arr[1];
            int w=arr[2];
            adj.get(ui).add(new Pair(vi, w));
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.offer(new int[]{k, 0});
        dist[k]=0;
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int parent=arr[0];
            int weight=arr[1];
            for(Pair child:adj.get(parent)){
                int node=child.node;
                int next=child.weight;
                if(next+weight<dist[node]){
                    dist[node]=next+weight;
                    pq.offer(new int[]{node, next+weight});
                }
            }
        }
        int max_ans=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            max_ans=Math.max(max_ans, dist[i]);
        }
        return max_ans;
    }
}
