class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n=len(nums)
        arr=[]
        for i in range(0,len(nums)-k+1):
            max_num=-10**9
            for j in range(i,i+k):
                max_num=max(max_num,nums[j])
            arr.append(max_num)

        return arr 