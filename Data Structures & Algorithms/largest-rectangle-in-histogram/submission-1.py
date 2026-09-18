class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n=len(heights)
        right_min=[0]*n
        stack=[]
        mini=-1
        for i in range(n-1,-1,-1):
            while stack and heights[i]<=heights[stack[-1]]:
                stack.pop()
            if not stack:
                right_min[i]=n
            else:
                right_min[i]=stack[-1]
            
            stack.append(i)
        
        left_min=[0]*n
        stack=[]
        for i in range(n):
            while stack and heights[i]<=heights[stack[-1]]:
                stack.pop()

            if not stack:
                left_min[i]=-1
            else:
                left_min[i]=stack[-1]
            
            stack.append(i)

        max_area=-1
        for i in range(n):
            max_area=max(max_area,(right_min[i]-left_min[i]-1)*heights[i])

        return max_area