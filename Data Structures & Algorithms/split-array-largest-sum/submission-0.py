class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        low,high=max(nums),sum(nums)
        while low<=high:
            mid=(low+high)//2
            curr_sum=0
            count=1
            for num in nums:
                if num+curr_sum>mid:
                    count+=1
                    curr_sum=num
                else:
                    curr_sum+=num
            
            if count<=k:
                high=mid-1
            else:
                low=mid+1
        
        return low