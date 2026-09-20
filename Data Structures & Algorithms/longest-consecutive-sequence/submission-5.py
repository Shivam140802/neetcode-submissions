import heapq

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        nums.sort()
        max_count = 1
        count = 1
        for i in range(1, len(nums)):
            if nums[i] == nums[i-1]:
                continue
            
            if nums[i] == nums[i-1]+1:
                count +=1
            else:
                count = 1
            
            max_count = max(count, max_count)
        
        return max_count