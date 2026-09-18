import random
class Solution:
    def partition(self,nums,low,high):
        pivot=nums[high]
        i=low
        for j in range(low,high):
            if nums[j]<=pivot:
                nums[i],nums[j]=nums[j],nums[i]
                i+=1
        nums[i],nums[high]=nums[high],nums[i]
        return i

    def select_random_pivot(self,nums,low,high):
        pivot_idx=random.randint(low,high)
        nums[pivot_idx],nums[high]=nums[high],nums[pivot_idx]
        return self.partition(nums,low,high)
    def quick_sort(self,nums,low,high):
        if low<high:
            pivot_idx=self.select_random_pivot(nums,low,high)
            self.quick_sort(nums,low,pivot_idx-1)
            self.quick_sort(nums,pivot_idx+1,high)
        
    def sortArray(self, nums: List[int]) -> List[int]:
        self.quick_sort(nums,0,len(nums)-1)
        return nums