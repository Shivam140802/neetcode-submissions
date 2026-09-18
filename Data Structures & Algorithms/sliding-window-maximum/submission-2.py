class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n=len(nums)
        arr=[]
        heap=[]
        for i in range(n):
            heapq.heappush(heap,(-nums[i],i))
            while heap[0][1]<=i-k:
                heapq.heappop(heap)
            if i>=k-1:
                arr.append(-heap[0][0])
        
        return arr