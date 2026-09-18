class StockSpanner:
    
    def __init__(self):
        self.stack=[]
        self.count=0
        self.stack.append((10**8,-1))

    def next(self, price: int) -> int:
        while self.stack and self.stack[-1][0]<=price:
            self.stack.pop()
        num=self.count-self.stack[-1][1]
        self.stack.append((price,self.count))
        self.count+=1
        return num


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)