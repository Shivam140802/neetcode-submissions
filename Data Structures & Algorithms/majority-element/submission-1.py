class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        res=nums[0]
        count=0
        for j in range(1,len(nums)):
            if count<0:
                res=nums[j]
            count+=(1 if nums[j]==res else -1)
        
        return res