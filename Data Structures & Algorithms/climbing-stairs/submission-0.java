class Solution {
    public int All(int n){
        if(n<=1) return 1;
        return All(n-1)+All(n-2);
    } 
    public int climbStairs(int n) {
        return All(n);
    }
}
