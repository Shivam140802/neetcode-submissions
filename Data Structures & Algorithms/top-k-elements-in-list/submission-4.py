from collections import Counter

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        frq = Counter(nums)
        frq_sort = dict(sorted(frq.items(), key = lambda x : x[1]))
        arr = []
        for key, value in reversed(frq_sort.items()):
            if k>0:
                arr.append(key)
                k-=1
            else:
                break
        
        return arr