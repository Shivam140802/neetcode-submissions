class Solution {
    public int find(int[] parent, int node){
        if(parent[node]==node) return node;
        return parent[node]=find(parent,parent[node]);
    }
    public boolean union(int[] parent, int[] rank, int a, int b){
        int parent_a=find(parent, a);
        int parent_b=find(parent, b);
        if(parent_a==parent_b) return false;
        if(rank[parent_a]<rank[parent_b]){
            parent[parent_a]=parent_b;
        }
        else if(rank[parent_a]>rank[parent_b]){
            parent[parent_b]=parent_a;
        }
        else{
            parent[parent_b]=parent_a;
            rank[parent_a]++;
        }
        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] parent=new int[n+1];
        for(int i=0;i<=n;i++) parent[i]=i;
        int[] rank=new int[n+1];
        for(int[] arr:edges){
            int a=arr[0], b=arr[1];
            if(!union(parent, rank, a, b)) return new int[]{a,b};
        }
        return new int[]{};
    }
}
