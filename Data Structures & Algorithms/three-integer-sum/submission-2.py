class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        nums.sort()
        res_arr = set()
        for i in range(0, n-2):
            target = nums[i]
            j, k = i+1, n-1
            while j<k:
                if nums[j] + nums[k] == -target:
                    res_arr.add((target, nums[j], nums[k]))
                    k-=1
                    j+=1
                elif nums[j] + nums[k] > -target:
                    k-=1
                else:
                    j+=1
        
        return [list(item) for item in res_arr]
        
