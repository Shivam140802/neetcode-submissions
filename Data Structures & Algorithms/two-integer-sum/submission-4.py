class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        freq ={}
        for index, value in enumerate(nums):
            freq[value] = index
        
        for i in range(len(nums)):

            complement= target - nums[i]
            if complement in freq and freq.get(complement)!=i:
                return [i, freq[complement]]
        
        return [0,0]