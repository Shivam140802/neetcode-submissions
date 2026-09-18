class Solution {
    public int find(int[] parent, int node){
        if(parent[node]==node) return parent[node];
        return parent[node]=find(parent, parent[node]);
    }
    public void union(int[] parent, int[] rank, int a, int b){
        int parent_a=find(parent, a);
        int parent_b=find(parent, b);
        if(parent_a==parent_b) return;
        if(rank[parent_a]<rank[parent_b]){
            parent[parent_a]=parent_b;
        }
        else if(rank[parent_a]>rank[parent_b]){
            parent[parent_b]=parent_a;
        }
        else{
            parent[parent_b]=parent_a;
            rank[parent_a]+=1;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        int[] parent=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        int[] rank=new int[n];
        HashMap<String, Integer> emailToIndex=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String key=accounts.get(i).get(j);
                if(emailToIndex.containsKey(key)){
                    union(parent, rank, i, emailToIndex.get(key));
                }
                emailToIndex.put(key,i);
            }
        }
        Map<Integer, TreeSet<String>> rootEmail=new HashMap<>();
        for(Map.Entry<String, Integer> map: emailToIndex.entrySet()){
            String email=map.getKey();
            int idx=find(parent, map.getValue());
            rootEmail.computeIfAbsent(idx, k->new TreeSet<>()).add(email);
        }
        List<List<String>> list=new ArrayList<>();
        for(Map.Entry<Integer, TreeSet<String>> map: rootEmail.entrySet()){
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(map.getKey()).get(0));
            temp.addAll(map.getValue());
            list.add(temp);
        }
        return list;
    }
}