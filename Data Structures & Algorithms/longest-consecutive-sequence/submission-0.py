class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s=set(nums)
        max_count=0
        for i in range(len(nums)):
            if nums[i]-1 in s:
                continue
            else:
                num=nums[i]
                count=0
                while num+1 in s:
                    count+=1
                    num=num+1
                max_count=max(max_count,count+1)
        
        return max_count