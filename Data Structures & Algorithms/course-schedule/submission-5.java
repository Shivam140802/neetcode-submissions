class Solution {
    public boolean dfs(List<List<Integer>> adj, int parent, HashSet<Integer> set){
        if(set.contains(parent)) return false;
        if(adj.get(parent).isEmpty()) return true;
        set.add(parent);
        for(int child:adj.get(parent)){
            if(!dfs(adj, child, set)) return false;
        }
        set.remove(parent);
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        if(n==0) return true; 
        int m=prerequisites[0].length;
        HashSet<Integer> set=new HashSet<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:prerequisites){
            adj.get(arr[0]).add(arr[1]);
        }
        for(int i=0;i<n;i++){
            if(!dfs(adj, i, set)){
                return false;
            }
            set.clear();
        }
        return true;
    }
}
