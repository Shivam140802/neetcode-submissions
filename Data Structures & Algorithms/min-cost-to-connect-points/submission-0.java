class Solution {
    class Pair{
        int node, weight;
        Pair(int node, int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dist=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                adj.get(i).add(new Pair(j, dist));
                adj.get(j).add(new Pair(i, dist));
            }
        }
        boolean[] vis=new boolean[points.length];
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.offer(new int[]{0,0});
        int max_val=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int parent=curr[0];
            int weight=curr[1];
            if(vis[parent]) continue;
            else vis[parent]=true;
            max_val+=weight;
            for(Pair child: adj.get(parent)){
                pq.offer(new int[]{child.node, child.weight});
            }
        }
        return max_val;
    }
}
