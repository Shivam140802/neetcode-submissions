class Solution {
    public int Max(int[] cost, int idx){
        if(idx>=cost.length) return 0;
        return cost[idx]+Math.min(Max(cost, idx+1), Max(cost, idx+2));
    }
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(Max(cost, 0), Max(cost, 1));
    }
}
