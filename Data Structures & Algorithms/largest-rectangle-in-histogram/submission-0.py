class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n=len(heights)
        arr=[]
        max_area=-1
        for i in range(n):
            j=i-1
            while j>=0:
                if heights[j]<heights[i]:
                    break
                j-=1
            
            k=i+1
            while k<n:
                if heights[k]<heights[i]:
                    break
                k+=1
            max_area=max(max_area,(k-j-1)*heights[i])
        
        return max_area