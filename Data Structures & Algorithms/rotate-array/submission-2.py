class Solution:
    def swap(self, nums, i, j):
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i+=1
            j-=1
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k = k%n
        self.swap(nums, n-k, n-1)
        self.swap(nums, 0, n-1)
        self.swap(nums, k, n-1)
        