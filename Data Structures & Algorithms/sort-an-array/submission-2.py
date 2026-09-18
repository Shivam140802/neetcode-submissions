import random
class Solution:
    def Partition(self, nums, low, high):
        partition_idx = random.randint(low, high)
        nums[partition_idx], nums[high] = nums[high], nums[partition_idx]
        i = low
        for j in range(low, high):
            if nums[j] <= nums[high]:
                nums[i], nums[j] = nums[j], nums[i]
                i+=1
        
        nums[i], nums[high] = nums[high], nums[i]
        return i

    def quickSort(self, nums, low, high):
        if low >= high:
            return
        
        partition_idx = self.Partition(nums, low,high)
        self.quickSort(nums, low, partition_idx-1)
        self.quickSort(nums, partition_idx+1, high)

    def sortArray(self, nums: List[int]) -> List[int]:
        self.quickSort(nums, 0, len(nums)-1)
        return nums