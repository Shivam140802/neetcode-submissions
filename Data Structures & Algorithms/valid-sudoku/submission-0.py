class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row_set=defaultdict(set)
        col_set=defaultdict(set)
        grid_set=defaultdict(set)

        for i in range(9):
            for j in range(9):
                num=board[i][j]
                if num==".":
                    continue
                grid_num=(i//3)*3+(j//3)
                if (num in row_set[i]) or (num in col_set[j]) or (num in grid_set[grid_num]):
                    return False
                row_set[i].add(num)
                col_set[j].add(num)
                grid_set[grid_num].add(num)
        
        return True