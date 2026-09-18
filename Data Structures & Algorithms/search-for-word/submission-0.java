class Solution {
    public boolean dfs(char[][] board, String word, int m, int n, int index){
        if(index==word.length()) return true;
        if(m<0 || n<0 || m==board.length || n==board[0].length || board[m][n]!=word.charAt(index)) return false;
        char temp=board[m][n];
        board[m][n]='#';
        boolean found=dfs(board, word, m-1, n, index+1) 
                        || dfs(board, word, m, n+1, index+1) 
                        || dfs(board, word, m+1, n, index+1) 
                        || dfs(board, word, m, n-1, index+1);
        board[m][n]=temp;
        return found;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(dfs(board, word, i, j, 0))
                return true;
            }
        }
        return false;
    }
}
