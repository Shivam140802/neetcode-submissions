class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        freq ={}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in freq:
                return [freq[complement], i]
            
            freq[nums[i]] = i
        
        return [0, 0]