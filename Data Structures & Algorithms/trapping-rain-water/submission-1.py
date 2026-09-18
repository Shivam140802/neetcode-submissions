class Solution:
    def trap(self, height: List[int]) -> int:
        maxwater=0
        for i in range(1,len(height)-1):
            
            leftmax=0
            for j in range(0,i+1):
                leftmax=max(height[j],leftmax)
            
            rightmax=0
            for j in range(i,len(height)):
                rightmax=max(height[j],rightmax)
            
            maxwater+=(min(leftmax,rightmax)-height[i])
        return maxwater