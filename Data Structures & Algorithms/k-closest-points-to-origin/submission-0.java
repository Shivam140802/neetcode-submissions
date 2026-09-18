class Solution {
    class Pair{
        double dist;
        int x,y;
        Pair(double dist, int x,int y){
            this.dist=dist;
            this.x=x;
            this.y=y;
        }
        public double getdist(){
            return dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] res=new int[k][2];
        PriorityQueue<Pair> pq=new PriorityQueue<>(Comparator.comparingDouble(Pair::getdist));
        for(int[] nums:points){
            int x=nums[0];
            int y=nums[1];
            double dist=Math.sqrt(x*x+y*y);
            pq.offer(new Pair(dist,x,y));
        }
        for(int i=0;i<k;i++){
            Pair obj=pq.poll();
            res[i][0]=obj.x;
            res[i][1]=obj.y;
        }

        return res;

    }
}
