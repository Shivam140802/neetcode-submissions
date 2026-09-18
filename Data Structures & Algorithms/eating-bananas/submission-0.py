class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        low,high=1,max(piles)
        min_rate=-1
        while low<=high:
            mid=(low+high)//2
            total_time=0
            for num in piles:
                if num%mid==0:
                    total_time+=num//mid
                else:
                    total_time+=(num+mid)//mid
            if total_time<=h:
                high=mid-1
            else:
                low=mid+1
        
        return low
