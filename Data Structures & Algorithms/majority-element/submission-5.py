class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        
        occur = 1
        curr_num = nums[0]
        for i in range(1, len(nums)):
            if nums[i]== curr_num:
                occur+=1
            else:
                occur-=1
                
            if occur < 0:
                curr_num = nums[i]
        
        return curr_num
        
        # for key in map:
        #     if map.get(key) > math.floor(len(nums)/2):
        #         return key
        
        # return -1