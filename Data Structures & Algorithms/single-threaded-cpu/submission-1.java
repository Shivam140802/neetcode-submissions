class Solution {
    class Pair{
        int start_time, process_time, index;
        Pair(int process_time, int index){
            this.process_time=process_time;
            this.index=index;
        }
        Pair(int start_time, int process_time, int index){
            this.start_time=start_time;
            this.process_time=process_time;
            this.index=index;
        }
        public int getS(){
            return start_time;
        }
        public int getP(){
            return process_time;
        }
        public int getI(){
            return index;
        }
    }
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparingInt(Pair::getP).thenComparingInt(Pair::getI));
        ArrayList<Pair> list=new ArrayList<>();
        for(int i=0;i<tasks.length;i++){
            list.add(new Pair(tasks[i][0], tasks[i][1], i));
        }
        Collections.sort(list, Comparator.comparingInt(Pair::getS));
        int time=list.get(0).getS();
        int i=0;
        while(i<list.size()){
            if(list.get(i).getS()<=time){
                pq.offer(new Pair(list.get(i).getP(), list.get(i).getI()));
            }
            else{
                break;
            }
            i+=1;
        }
        int[] res=new int[tasks.length];
        int j=0;
        while(!pq.isEmpty()){
            Pair obj=pq.poll();
            res[j]=obj.getI();
            j+=1;
            time+=obj.getP();
            while(i<list.size() && list.get(i).getS()<=time){
                pq.offer(new Pair(list.get(i).getP(), list.get(i).getI()));
                i+=1;
            }
            if(i<list.size() && pq.isEmpty()){
                time=list.get(i).getS();
                pq.offer(new Pair(list.get(i).getP(), list.get(i).getI()));
                i+=1;
            }
        }
        return res;
    }
}