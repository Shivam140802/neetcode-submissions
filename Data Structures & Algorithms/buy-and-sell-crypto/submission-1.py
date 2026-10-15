class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        min_num = prices[0] 
        for i in range(1, len(prices)):
            if prices[i] > min_num:
                profit = max(profit, prices[i] - min_num)
            else:
                min_num = prices[i]
        
        return profit