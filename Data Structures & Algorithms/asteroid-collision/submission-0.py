class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        n=len(asteroids)
        stack=[]
        for i in range(n):
            flag=False
            while stack and stack[-1]>0 and asteroids[i]<0:
                if stack[-1]==abs(asteroids[i]):
                    stack.pop()
                    flag=True
                    break
                elif stack[-1]<abs(asteroids[i]):
                    stack.pop()
                else:
                    flag=True
                    break
            
            if not flag:
                stack.append(asteroids[i])
            
        return stack