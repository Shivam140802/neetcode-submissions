class Solution {
    int[][] direction={{-1,0},{0,1},{1,0},{0,-1}};
    int n,m;
    public void dfs(char[][] board, boolean[][] vis, int i, int j){
        vis[i][j]=true;
        board[i][j]='#';
        for(int[] dir:direction){
            int new_i=i+dir[0];
            int new_j=j+dir[1];
            if(new_i>=0 && new_j>=0 && new_i<n && new_j<m && !vis[new_i][new_j] && board[new_i][new_j]=='O'){
                dfs(board, vis, new_i, new_j);
            }
        }
    }
    public void solve(char[][] board) {
        n=board.length;
        m=board[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && !vis[i][0]){
                dfs(board, vis, i, 0);
            }
            if(board[i][m-1]=='O' && !vis[i][m-1]){
                dfs(board, vis, i, m-1);
            }
        }
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && !vis[0][i]){
                dfs(board, vis, 0, i);
            }
            if(board[n-1][i]=='O' && !vis[n-1][i]){
                dfs(board, vis, n-1, i);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='#') board[i][j]='O';
                else board[i][j]='X';
            }
        }
    }
}
