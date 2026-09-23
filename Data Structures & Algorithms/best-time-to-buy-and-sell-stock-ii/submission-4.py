class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        for i in range(1, len(prices)):
            last_price = prices[i-1]
            curr_price = prices[i]
            if curr_price > last_price:
                max_profit += curr_price - last_price
        
        return max_profit