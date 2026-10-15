class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        mapping = {}
        for i in range(0, len(nums)):
            if nums[i] in mapping and abs(mapping[nums[i]] - i) <= k:
                return True
            
            mapping[nums[i]] = i
        
        return False