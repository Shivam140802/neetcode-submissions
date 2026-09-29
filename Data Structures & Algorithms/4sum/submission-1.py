class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        n = len(nums)
        nums.sort()
        if n < 4:
            return []
        res_arr = set()
        for i in range(0, n-3):
            for j in range(i+1, n-2):
                k, l = j+1, n-1
                new_target = target - (nums[i] + nums[j])
                while k < l:
                    if nums[k] + nums[l] == new_target:
                        res_arr.add((nums[i], nums[j], nums[k], nums[l]))
                        l-=1
                        k+=1
                    elif nums[k] + nums[l] > new_target:
                        l-=1
                    else:
                        k+=1
        
        return list(res_arr)