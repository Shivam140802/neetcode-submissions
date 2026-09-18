class Solution {
    public boolean isValid(char[][] board, int row, int col, int n){
        boolean isCol=true;
        for(int i=0;i<=row;i++){
            if(board[i][col]=='Q'){
                isCol=false;
                break;
            }
        }
        boolean leftDia=true;
        int currRow=row-1, currCol=col-1;
        while(currRow>=0 && currCol>=0){
            if(board[currRow][currCol]=='Q'){
                leftDia=false;
                break;
            }
            currRow-=1;
            currCol-=1;
        }
        boolean rightDia=true;
        currRow=row-1;
        currCol=col+1;
        while(currRow>=0 && currCol<n){
            if(board[currRow][currCol]=='Q'){
                rightDia=false;
                break;
            }
            currRow-=1;
            currCol+=1;
        }
        return isCol && leftDia && rightDia;
    }
    public void Queen(int n, char[][] board, List<List<String>> list, int row){
        if(row==n){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++){
                    sb.append(board[i][j]);
                }
                temp.add(sb.toString());
            }
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int col=0;col<n;col++){
            if(isValid(board, row, col, n)){
                board[row][col]='Q';
                Queen(n, board, list, row+1);
                board[row][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        List<List<String>> list=new ArrayList<>();
        Queen(n, board, list, 0);
        return list;
    }
}
