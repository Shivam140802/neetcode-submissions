class Solution:
    def trap(self, height: List[int]) -> int:
        n=len(height)

        rightmax=[0]*n
        rightmax[0]=height[0]
        for i in range(1,n):
            rightmax[i]=max(rightmax[i-1],height[i])
        
        leftmax=[0]*n
        leftmax[n-1]=height[n-1]
        for i in range(n-2,-1,-1):
            leftmax[i]=max(leftmax[i+1],height[i])

        maxwater=0
        for i in range(n):
            maxwater+=(min(leftmax[i],rightmax[i])-height[i])
        return maxwater