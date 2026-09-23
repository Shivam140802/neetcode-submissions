class Solution:
    def max_profit(self, prices, idx, n, can_buy, dp_arr):
        if idx >= n:
            return 0
        
        if (idx, can_buy) in dp_arr:
            return dp_arr[(idx, can_buy)]

        if can_buy:
            buy = -prices[idx] + self.max_profit(prices, idx+1, n, False, dp_arr)
            skip = self.max_profit(prices, idx+1, n, True, dp_arr)
            profit = max(buy , skip)
        else:
            sell = prices[idx] + self.max_profit(prices, idx+1, n, True, dp_arr)
            hold = self.max_profit(prices, idx+1, n, False, dp_arr)
            profit = max(sell, hold)
        
        dp_arr[(idx, can_buy)] = profit
        return profit

    def maxProfit(self, prices: List[int]) -> int:
        dp_arr = {}
        return self.max_profit(prices, 0, len(prices), True, dp_arr)