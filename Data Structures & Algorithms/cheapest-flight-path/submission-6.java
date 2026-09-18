class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist=new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        for(int i=0;i<=k;i++){
            int[] temp=Arrays.copyOf(dist, n);
            for(int j=0;j<flights.length;j++){
                int from=flights[j][0];
                int to=flights[j][1];
                int weight=flights[j][2];
                if(dist[from]!=Integer.MAX_VALUE && dist[from]+weight<temp[to]){
                    temp[to]=dist[from]+weight;
                }
            }
            dist=temp;
        }
        return dist[dst]==Integer.MAX_VALUE? -1: dist[dst];
    }
}
