class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Collections.singletonList(0);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        int[] indegree=new int[n];
        for(int[] edge:edges){
            int a=edge[0];
            int b=edge[1];
            list.get(a).add(b);
            list.get(b).add(a);
            indegree[a]+=1;
            indegree[b]+=1;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==1){
                q.offer(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int len=q.size();
            ans=new ArrayList<>();
            for(int i=0;i<len;i++){
                int curr=q.poll();
                ans.add(curr);
                for(int child:list.get(curr)){
                    indegree[child]-=1;
                    if(indegree[child]==1){
                        q.offer(child);
                    }
                }
            }
        }
        return ans;
    }
}