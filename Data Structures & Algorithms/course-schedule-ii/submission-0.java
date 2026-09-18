class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];
        Queue<Integer> q=new LinkedList<>();
        int[] vis=new int[numCourses];
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(i, new ArrayList<>());
        }
        for(int[] arr:prerequisites){
            adj.get(arr[1]).add(arr[0]);
            indegree[arr[0]]+=1;
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int num=q.poll();
            list.add(num);
            for(int child:adj.get(num)){
                indegree[child]-=1;
                if(indegree[child]==0){
                    q.offer(child);
                }
            }
        }
        if(list.size()<numCourses) return new int[0];
        int[] res=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            res[i]=list.get(i);
        }

        return res;

    }
}
