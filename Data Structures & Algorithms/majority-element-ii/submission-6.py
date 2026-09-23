class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        frq = {}
        for num in nums:
            if num in frq:
                frq[num] = frq[num] +1
            else:
                frq[num] = 1
        
        res = []
        for key, value in frq.items():
            if value > len(nums) // 3:
                res.append(key)
        
        return res