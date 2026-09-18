class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        dic={}
        for num in nums:
            dic[num]=dic.get(num,0)+1
        
        for key,val in dic.items():
            if val>1:
                return key
        
        return -1