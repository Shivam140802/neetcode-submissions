class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix=nums[:]
        suffix=nums[:]
        for i in range(1,len(nums)):
            prefix[i]*=prefix[i-1]
        
        for i in range(len(nums)-2,-1,-1):
            suffix[i]*=suffix[i+1]

        res=[]
        res.append(suffix[1])
        for i in range(1,len(nums)-1):
            res.append(prefix[i-1]*suffix[i+1])
        res.append(prefix[len(nums)-2])
        
        return res