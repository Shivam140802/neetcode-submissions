class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        low,high=max(weights),sum(weights)
        while low<=high:
            mid=(low+high)//2
            count,total_sum=1,0
            for i in range(len(weights)):
                if weights[i]+total_sum>mid:
                    total_sum=weights[i]
                    count+=1
                else:
                    total_sum+=weights[i]
            if count<=days:
                high=mid-1
            else:
                low=mid+1
        
        return low
