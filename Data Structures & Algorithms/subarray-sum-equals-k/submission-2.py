class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefix_sum = []
        previous_sum = 0
        for num in nums:
            prefix_sum.append(num+previous_sum)
            previous_sum = prefix_sum[-1]
        
        frq = {}
        frq[0] = 1
        count = 0
        for num in prefix_sum:
            if num - k in frq:
                count += frq[num - k]
            
            if num in frq:
                frq[num] +=1
            else:
                frq[num] = 1
        
        return count