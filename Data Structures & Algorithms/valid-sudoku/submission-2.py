class Solution:

    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        #check row
        for row in range(9):
            seen = set()
            for i in range(9):
                if board[row][i] == ".":
                    continue
                if board[row][i] in seen:
                    return False
                
                seen.add(board[row][i])
        
        #check column
        for col in range(9):
            seen = set()
            for i in range(9):
                if board[i][col] == ".":
                    continue
                if board[i][col] in seen:
                    return False
                
                seen.add(board[i][col])
        
        #check grid
        seen = set()
        for i in range(9):
            for j in range(9):
                if board[i][j] == ".":
                    continue
                row = i // 3
                col = j // 3
                st = str(row)+str(col)+str(board[i][j])
                if st in seen:
                    return False
                seen.add(st)


        return True
