class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        prefix_prod = [0] *n
        prefix_prod[0] = nums[0]
        for i in range(1, n):
            prefix_prod[i] = prefix_prod[i-1] * nums[i] 
        
        suffix_prod = [0] * n
        suffix_prod[n-1] = nums[n-1]
        for i in range(len(nums)-2 , -1 , -1):
            suffix_prod[i] = suffix_prod[i+1] * nums[i]
        
        res = []
        res.append(suffix_prod[1])
        for i in range(1, n-1):
            res.append(prefix_prod[i-1] * suffix_prod[i+1])
        res.append(prefix_prod[n-2])
        return res