class Solution {
    HashMap<String, PriorityQueue<String>> adj=new HashMap<>();
    LinkedList<String> ans=new LinkedList<>();
    public void dfs(String st){
        PriorityQueue<String> pq=adj.get(st);
        while (pq!=null && !pq.isEmpty()){
            String next=pq.poll();
            dfs(next);
        }
        ans.addFirst(st); 
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> list:tickets){
            String st1=list.get(0);
            String st2=list.get(1);
            adj.computeIfAbsent(st1, k -> new PriorityQueue<>()).offer(st2);
        }
        dfs("JFK");
        return ans;
    }
}
