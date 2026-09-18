class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        n=len(nums)
        left=0
        summ=0
        min_len=10**9
        for right in range(n):
            summ+=nums[right]
            while summ>=target:
                min_len=min(min_len,right-left+1)
                summ-=nums[left]
                left+=1
        
        return min_len if min_len!=10**9 else 0