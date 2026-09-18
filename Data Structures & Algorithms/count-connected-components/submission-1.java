class Solution {
    public void dfs(List<List<Integer>> adj, int parent, boolean[] vis){
        vis[parent]=true;
        for(int child:adj.get(parent)){
            if(!vis[child]){
                dfs(adj, child, vis);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(adj, i, vis);
                count+=1;
            }
        }
        return count;
    }
}
