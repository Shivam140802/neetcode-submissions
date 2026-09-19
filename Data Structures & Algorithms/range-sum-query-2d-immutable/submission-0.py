class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        self.matrix = matrix
        self.row = len(matrix)
        self.column = len(matrix[0])

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        sum = 0
        self.temp = [[False for _ in range(self.column)] for _ in range(self.row)]
        for i in range(row1, row2+1):
            for j in range(col1 , col2+1):
                if i >= 0 and i < self.row and j >= 0 and j < self.column and self.temp[i][j] ==False:
                    sum+= self.matrix[i][j]
                    self.temp[i][j] = True
        
        return sum


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)