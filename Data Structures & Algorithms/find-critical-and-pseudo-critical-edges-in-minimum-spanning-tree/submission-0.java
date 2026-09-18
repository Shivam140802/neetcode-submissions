class Solution {
    public int find(int[] parent, int node){
        if(parent[node]==node) return node;
        return parent[node]=find(parent, parent[node]);
    }
    public boolean union(int[] parent, int[] rank, int a, int b){
        int parent_a=find(parent, a);
        int parent_b=find(parent, b);
        if(parent_a==parent_b) return false;

        if(rank[parent_a]<rank[parent_b]) parent[parent_a]=parent_b;
        else if(rank[parent_a]>rank[parent_b]) parent[parent_b]=parent_a;
        else{
            parent[parent_b]=parent_a;
            rank[parent_a]+=1;
        }
        return true;
    }
    public int krushkal(List<List<Integer>> adj, int skip, int add, int n){
        int min_span=0;
        int[] parent=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        int[] rank=new int[n];

        int count=0;
        if(add!=-1){
            int a=adj.get(add).get(0);
            int b=adj.get(add).get(1);
            int w=adj.get(add).get(2);
            int idx=adj.get(add).get(3);
            if(union(parent, rank, a, b)){
                min_span+=w;
                count+=1;
            }
        }
        for(int i=0;i<adj.size();i++){
            if(skip==i) continue;
            int a=adj.get(i).get(0);
            int b=adj.get(i).get(1);
            int w=adj.get(i).get(2);
            int idx=adj.get(i).get(3);

            if(union(parent, rank, a, b)){
                min_span+=w;
                count+=1;
            }
        }
        return count==n-1? min_span: Integer.MAX_VALUE;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            List<Integer> list=new ArrayList<>();
            list.add(edges[i][0]);
            list.add(edges[i][1]);
            list.add(edges[i][2]);
            list.add(i);
            adj.add(new ArrayList<>(list));
        }
        Collections.sort(adj, Comparator.comparingInt(a->a.get(2)));
        int MST=krushkal(adj, -1, -1, n);
        List<Integer> critical=new ArrayList<>();
        List<Integer> pseudo_critical=new ArrayList<>();
        for(int i=0;i<adj.size();i++){
            int idx=adj.get(i).get(3);
            if(krushkal(adj, i, -1, n)>MST){
                critical.add(idx);
            }
            else if(krushkal(adj, -1, i, n)==MST){
                pseudo_critical.add(idx);
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(critical);
        ans.add(pseudo_critical);
        return ans;
    }
}