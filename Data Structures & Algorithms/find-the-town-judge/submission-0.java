class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degree=new int[n+1];
        for(int[] p:trust){
            degree[p[0]]-=1;
            degree[p[1]]+=1;
        }
        for(int i=0;i<degree.length;i++){
            if(degree[i]==n-1) return i;
        }
        return -1;
    }
}