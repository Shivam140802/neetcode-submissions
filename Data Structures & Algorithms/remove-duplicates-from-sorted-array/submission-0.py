class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        arr=[0]*201
        for num in nums:
            arr[num+100]=1
        
        count=0
        for i in range(len(arr)):
            if arr[i]==1:
                nums[count]=i-100
                count+=1
        
        return count