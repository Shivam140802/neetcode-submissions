class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n=len(temperatures)
        stack=[]
        arr=[]
        for i in range(n-1,-1,-1):
            while stack and temperatures[i]>=temperatures[stack[-1]]:
                stack.pop()
            if not stack:
                arr.append(0)
            else:
                arr.append(stack[-1]-i)
            stack.append(i)
        
        return arr[::-1]