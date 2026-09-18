class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int a=edge[0];
            int b=edge[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        int min_height;
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        for(int i=0;i<n;i++){
            Queue<Integer> q=new LinkedList<>();
            boolean[] vis=new boolean[n];
            q.offer(i);
            int count=0;
            while(!q.isEmpty()){
                int len=q.size();
                for(int j=0;j<len;j++){
                    int curr=q.poll();
                    vis[curr]=true;
                    for(int child:list.get(curr)){
                        if(!vis[child]){
                            q.offer(child);
                        }
                    }
                }
                count+=1;
            }
            pq.offer(new int[]{i, count});
        }
        List<Integer> ans=new ArrayList<>();
        int[] arr=pq.poll();
        ans.add(arr[0]);
        while(!pq.isEmpty() && pq.peek()[1]==arr[1]){
            ans.add(pq.poll()[0]);
        }
        return ans;
    }
}