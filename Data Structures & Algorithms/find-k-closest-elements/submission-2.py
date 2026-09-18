class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        max_heap=[]
        for i in range(len(arr)):
            diff=abs(arr[i]-x)
            heapq.heappush(max_heap,(-diff,-arr[i]))
            if len(max_heap)>k:
                heapq.heappop(max_heap)
        
        return sorted([-num for _,num in max_heap])
        