class Solution {
    public int Unique(int i, int j, int m, int n){
        if(i==m-1 && j==n-1) return 1;

        if(i>=m || j>=n) return 0;

        return Unique(i+1, j, m, n)+Unique(i, j+1, m, n);
    }
    public int uniquePaths(int m, int n) {
        return Unique(0, 0, m, n);
    }
}
