class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        unique_num = set(nums)
        max_num = max(nums)

        for i in range(1, 2**31, 1):
            if i not in unique_num and i>0:
                return i
        
        return 0