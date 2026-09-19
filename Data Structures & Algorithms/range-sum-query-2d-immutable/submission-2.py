class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        self.matrix = matrix
        self.row = len(matrix)
        self.column = len(matrix[0])

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        prefix_sum = [[0 for _ in range(self.column + 1)] for _ in range(self.row+1)]
        for i in range(1, self.row+1):
            for j in range(1, self.column+1):
                prefix_sum[i][j] = self.matrix[i-1][j-1] + prefix_sum[i-1][j] + prefix_sum[i][j-1] - prefix_sum[i-1][j-1]
        
        return prefix_sum[row2+1][col2+1] - prefix_sum[row1][col2 + 1] - prefix_sum [row2+1][col1] +prefix_sum[row1][col1]



# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)