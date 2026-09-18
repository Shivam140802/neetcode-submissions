class Solution {
    class Pair{
        int node, weight;
        Pair(int node, int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:flights){
            adj.get(arr[0]).add(new Pair(arr[1], arr[2]));
        }
        int[] dist=new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{src, 0});
        dist[src]=0;
        int steps=0;
        while(!q.isEmpty() && steps<=k){
            int len=q.size();
            for(int i=0;i<len;i++){
                int[] curr=q.poll();
                int node=curr[0];
                int weight=curr[1];
                for(Pair child: adj.get(node)){
                    int new_node=child.node;
                    int new_weight=child.weight;
                    if(new_weight+weight<dist[new_node]){
                        dist[new_node]=new_weight+weight;
                        q.offer(new int[]{new_node, new_weight+weight});
                    }
                }
            }
            steps+=1;
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}
