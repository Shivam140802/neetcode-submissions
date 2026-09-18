class Solution {
    public boolean Topo(int k,int[][] cond, ArrayList<Integer> list){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=k;i++){
            adj.add(new ArrayList<>());
        }
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=1;i<=k;i++){
            map.put(i,0);
        }
        for(int[] arr: cond){
            adj.get(arr[0]).add(arr[1]);
            map.put(arr[1], map.getOrDefault(arr[1], 0)+1);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int key: map.keySet()){
            if(map.get(key)==0){
                q.offer(key);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            map.remove(node);
            list.add(node);
            for(int child: adj.get(node)){
                map.put(child, map.get(child)-1);
                if(map.get(child)==0){
                    q.offer(child);
                }
            }
        }
        return map.size()==0? true: false;
    }
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        ArrayList<Integer> rowOrder=new ArrayList<>();
        ArrayList<Integer> columnOrder=new ArrayList<>();
        boolean flag1=Topo(k, rowConditions, rowOrder);
        boolean flag2=Topo(k, colConditions, columnOrder);
        
        if(!flag1 || !flag2) return new int[0][0];

        HashMap<Integer, Integer> map1=new HashMap<>();
        for(int i=0;i<rowOrder.size();i++){
            map1.put(rowOrder.get(i), i);
        }
        HashMap<Integer, Integer> map2=new HashMap<>();
        for(int i=0;i<columnOrder.size();i++){
            map2.put(columnOrder.get(i), i);
        }
        int[][] arr=new int[k][k];
        for(int i=1;i<=k;i++){
            int row=map1.get(i);
            int column=map2.get(i);
            arr[row][column]=i;
        }
        return arr;
    }
}