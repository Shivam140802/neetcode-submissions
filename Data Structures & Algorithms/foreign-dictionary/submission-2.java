class Solution {
    public String topo(HashMap<Character, HashSet<Character>> adj, HashMap<Character, Integer> indegree){
        StringBuilder sb=new StringBuilder();
        Queue<Character> q=new LinkedList<>();
        for(char key: indegree.keySet()){
            if(indegree.get(key)==0){
                q.offer(key);
            }
        }
        while(!q.isEmpty()){
            char key=q.poll();
            sb.append(key);
            for(char node : adj.getOrDefault(key, new HashSet<>())){
                indegree.put(node, indegree.get(node)-1);
                if(indegree.get(node)==0){
                    q.offer(node);
                }
            }
        }
        if (sb.length() != indegree.size()) return "";
        return sb.toString();
    }
    public String foreignDictionary(String[] words) {
        int n=words.length;
        HashMap<Character, HashSet<Character>> adj=new HashMap<>();
        HashMap<Character, Integer> indegree=new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.putIfAbsent(c, 0);
            }
        }
        for(int i=0;i<n-1;i++){
            String s1=words[i];
            String s2=words[i+1];
            int len=Math.min(s1.length(), s2.length());
            if(s1.length()>s2.length() && s1.startsWith(s2)) return "";
            for(int j=0;j<len;j++){
                char c1=s1.charAt(j) , c2=s2.charAt(j);
                if(c1!=c2){
                    adj.putIfAbsent(c1, new HashSet<>());
                    if(!adj.get(c1).contains(c2)){
                        adj.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        return topo(adj, indegree);
    }
}
