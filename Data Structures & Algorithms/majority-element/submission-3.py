class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        map = {}
        for n in nums:
            map[n] = map.get(n, 0)+1
            if map.get(n) > math.floor(len(nums)/2):
                return n
        
        return -1
        
        # for key in map:
        #     if map.get(key) > math.floor(len(nums)/2):
        #         return key
        
        # return -1