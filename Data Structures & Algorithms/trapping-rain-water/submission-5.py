class Solution:
    # def find_left_max(self, nums, idx):
    #     current_val = nums[idx]
    #     while idx >=0:
    #         if nums[idx] > current_val:
    #             current_val = nums[idx]
    #         idx-=1
        
    #     return current_val
    
    # def find_right_max(self, nums, idx):
    #     current_val = nums[idx]
    #     while idx < len(nums):
    #         if nums[idx] > current_val:
    #             current_val = nums[idx]
    #         idx+=1
        
    #     return current_val
    
    def trap(self, height: List[int]) -> int:
        n = len(height)
        left_max = [0] * n
        right_max = [0] * n

        left_max[0] = height[0]
        left_max_num = height[0]
        for i in range(1, n):
            if left_max_num > height[i]:
                left_max[i] = left_max_num
            else:
                left_max[i] = height[i]
                left_max_num = height[i]
        
        left_max[n-1] = height[n-1]
        right_max_num = height[n-1]
        for i in range(n-2, 0, -1):
            if right_max_num > height[i]:
                right_max[i] = right_max_num
            else:
                right_max[i] = height[i]
                right_max_num = height[i]

        max_water = 0
        for i in range(1, n-1):
            value = min(left_max[i], right_max[i]) - height[i]
            if value > 0:
                max_water += value
        
        return max_water