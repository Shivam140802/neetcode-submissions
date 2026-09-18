class Solution {
    public boolean dfs(HashMap<Integer, List<Integer>> map, int node, int target, boolean[] vis){
        if(node==target) return true;
        vis[node]=true;
        for(int child:map.get(node)){
            if(!vis[child] && dfs(map, child, target, vis)){
                return true;
            }
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i, new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            boolean[] vis=new boolean[n+1];
            if(map.containsKey(a) && map.containsKey(b) && dfs(map, a, b, vis)){
                return new int[]{a,b};
            }
            map.get(a).add(b);
            map.get(b).add(a);
        }
        return new int[]{};
    }
}
