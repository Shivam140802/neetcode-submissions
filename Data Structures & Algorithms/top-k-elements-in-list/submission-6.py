from collections import Counter
import heapq

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        frq = Counter(nums)
        max_elements = max(frq.values())
        arr = [[] for _ in range(max_elements+1)]
        for key, value in frq.items():
            arr[value].append(key)

        result = []
        for i in range(len(arr)-1, -1, -1):
            for j in range(0, len(arr[i])):
                if k>0:
                    result.append(arr[i][j])
                    k-=1
        
        return result