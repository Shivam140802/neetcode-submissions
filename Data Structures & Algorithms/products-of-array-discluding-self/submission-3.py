class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        prod = 1
        zeroCnt = 0
        for num in nums:
            if num == 0:
                zeroCnt +=1
                continue
            prod *= num
        
        res = [0] * n
        if zeroCnt > 1:
            return res
        
        if zeroCnt == 1:
            for i in range(0, n):
                if nums[i] == 0:
                    res[i] = prod
            
            return res
        
        for i in range(0, n):
            res[i] = prod // nums[i]
        
        return res
