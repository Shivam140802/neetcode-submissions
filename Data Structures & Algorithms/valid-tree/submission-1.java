class Solution {
    public boolean dfs(List<List<Integer>> adj, HashSet<Integer> vis, int parent, int grand){
        if(vis.contains(parent)) return false;
        vis.add(parent);
        for(int child: adj.get(parent)){
            if(child==grand) continue;
            if(!dfs(adj, vis, child, parent)) return false;
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        HashSet<Integer> vis=new HashSet<>();
        return dfs(adj, vis, 0, -1) && vis.size()==n;
    }
}
