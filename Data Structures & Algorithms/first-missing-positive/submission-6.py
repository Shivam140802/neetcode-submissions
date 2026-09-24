class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        unique_num = set(nums)
        max_num = max(nums)
        missing_num = 2**31
        for i in range(1, 2**31, 1):
            if i not in unique_num:
                missing_num = i
                break
        
        return missing_num