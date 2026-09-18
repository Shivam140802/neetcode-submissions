class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        dictionary={}
        for i in range(len(nums)):
            dictionary[nums[i]]=dictionary.get(nums[i],0)+1
        
        length=len(nums)//3
        res=[]
        for key,val in dictionary.items():
            if val>length:
                res.append(key)
        
        return res