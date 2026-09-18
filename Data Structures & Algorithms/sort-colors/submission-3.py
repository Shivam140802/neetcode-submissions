class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i,j,k=0,0,len(nums)-1
        while i<=k:
            if nums[i]==0:
                nums[i],nums[j]=nums[j],nums[i]
                j+=1
                i+=1
            elif nums[i]==2:
                nums[k],nums[i]=nums[i],nums[k]
                k-=1
            else:
                i+=1
        
        return nums
        