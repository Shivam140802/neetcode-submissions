class Solution:
    def check_row(self, row, board):
        mapping = set()
        for column in range(9):
            if self.board[row][column] == '.':
                continue
            if self.board[row][column] in mapping:
                return True
            mapping.add(self.board[row][column])
        
        return False
    
    def check_column(self, column, board):
        mapping = set()
        for row in range(9):
            if self.board[row][column] == '.':
                continue
            if self.board[row][column] in mapping:
                return True
            mapping.add(self.board[row][column])
        
        return False
    
    def check_grid(self, row, col, board):
        start_row = (row//3) * 3
        start_col = (col//3) * 3
        mapping = set()
        for i in range(start_row, start_row+3):
            for j in range(start_col, start_col+3):
                if self.board[i][j] == '.':
                    continue
                if self.board[i][j] in mapping:
                    return True
                mapping.add(self.board[i][j])
        return False

    def isValidSudoku(self, board: List[List[str]]) -> bool:
        self.board = board
        for i in range(9):
            for j in range(9):
                if (self.check_row(i, self.board) or self.check_column(j, self.board) or 
                self.check_grid(i,j,self.board)):
                    return False
        
        return True
