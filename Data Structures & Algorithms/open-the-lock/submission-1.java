class Solution {
    public List<String> getNeighbors(String st){
        char[] arr=st.toCharArray();
        List<String> list=new ArrayList<>();
        for(int i=0;i<4;i++){
            char c=arr[i];
            arr[i]= (c=='9') ?'0' :(char)(c+1);
            list.add(new String(arr));
            arr[i]= (c=='0') ?'9' :(char)(c-1);
            list.add(new String(arr));

            arr[i]=c;
        }
        return list;
    }
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead=new HashSet<>(Arrays.asList(deadends));
        if(dead.contains("0000")) return -1;
        Queue<String> q=new LinkedList<>();
        q.offer("0000");
        HashSet<String> visited=new HashSet<>();
        visited.add("0000");
        int count=0;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                String curr=q.poll();
                if(curr.equals(target)) return count;
                for(String st: getNeighbors(curr)){
                    if(!visited.contains(st) && !dead.contains(st)){
                        visited.add(st);
                        q.offer(st);
                    }
                }
            }
            count+=1;
        }
        return -1;
    }
}