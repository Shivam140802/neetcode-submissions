class Solution {
    public boolean bfs(HashMap<Integer, List<Integer>> map, int node, int target){
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        q.offer(node);
        while(!q.isEmpty()){
            int curr=q.poll();
            if(curr==target) return true;
            for(int child:map.get(curr)){
                if(!set.contains(child)){
                    q.offer(child);
                    set.add(child);
                }
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
            if(map.containsKey(a) && map.containsKey(b) && bfs(map, a, b)){
                return new int[]{a,b};
            }
            map.get(a).add(b);
            map.get(b).add(a);
        }
        return new int[]{};
    }
}
