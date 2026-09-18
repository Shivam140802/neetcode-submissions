class Solution:
    def max_profit(self,prices,d,ind,can_buy):
        if ind==len(prices):
            return 0
        if (ind,can_buy) in d:
            return d[(ind,can_buy)]
        if can_buy:
            profit=max(-prices[ind]+self.max_profit(prices,d,ind+1,0),
            self.max_profit(prices,d,ind+1,1))
        else:
            profit=max(prices[ind]+self.max_profit(prices,d,ind+1,1),
            self.max_profit(prices,d,ind+1,0))
        d[(ind,can_buy)]=profit
        return profit

    def maxProfit(self, prices: List[int]) -> int:
        d={}
        return self.max_profit(prices,d,0,1)