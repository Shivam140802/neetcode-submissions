class Solution {
    public boolean dfs(List<List<Integer>> adj, int node, int target, boolean[] vis){
        if(node==target) return true;
        vis[node]=true;
        for(int child:adj.get(node)){
            if(!vis[child] && dfs(adj, child, target, vis)) return true;
        }
        return false;
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr: prerequisites){
            adj.get(arr[0]).add(arr[1]);
        }
        List<Boolean> ans=new ArrayList<>();
        for(int[] q:queries){
            boolean[] vis=new boolean[numCourses];
            ans.add(dfs(adj, q[0], q[1], vis));
        }
        return ans;
    }
}