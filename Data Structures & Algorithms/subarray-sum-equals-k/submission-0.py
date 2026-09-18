class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        n=len(nums)
        mape={}
        mape[0]=1
        prefix_sum=0
        count=0
        for num in nums:
            prefix_sum+=num
            if prefix_sum-k in mape:
                count+=mape[prefix_sum-k]
            mape[prefix_sum]=mape.get(prefix_sum,0)+1
        
        return count