class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr: prerequisites){
            adj.get(arr[0]).add(arr[1]);
            indegree[arr[1]]+=1;
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        HashMap<Integer, HashSet<Integer>> map=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i, new HashSet<>());
        }
        while(!q.isEmpty()){
            int parent=q.poll();
            for(int child: adj.get(parent)){
                map.get(child).add(parent);
                map.get(child).addAll(map.get(parent));
                indegree[child]-=1;
                if(indegree[child]==0){
                    q.offer(child);
                }
            }
        }
        List<Boolean> list=new ArrayList<>();
        for(int[] query:queries){
            if(map.get(query[1]).contains(query[0])){
                list.add(true);
            }
            else{
                list.add(false);
            }
        }
        return list;
    }
}