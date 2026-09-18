class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        def merge(nums, low, mid, high):
            left, right = nums[low: mid+1], nums[mid+1: high+1]
            i, j, k = 0, 0, low

            while i < len(left) and j < len(right):
                if left[i]<= right[j]:
                    nums[k] = left[i]
                    i+=1
                else:
                    nums[k] = right[j]
                    j+=1
                
                k+=1
            
            while i < len(left):
                nums[k] = left[i]
                i+=1
                k+=1
            
            while j < len(right):
                nums[k] = right[j]
                j+=1
                k+=1

        def mergeSort(nums , low, high):
            if low >= high:
                return
            
            mid = (low + high) // 2
            mergeSort(nums, low, mid)
            mergeSort(nums, mid+1, high)
            merge(nums, low, mid, high)
        
        mergeSort(nums, 0, len(nums)-1)
        return nums