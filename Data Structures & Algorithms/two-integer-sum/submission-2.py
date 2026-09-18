class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic={}
        a,b=-1,-1
        for i in range(len(nums)):
            if nums[i] in dic:
                a=dic[nums[i]]
                b=i
                break
            else:
                dic[target-nums[i]]=i
        
        return [a,b]