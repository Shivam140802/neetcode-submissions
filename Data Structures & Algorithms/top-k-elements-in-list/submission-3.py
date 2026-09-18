class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq=defaultdict(int)
        s=set()
        for i in range(len(nums)):
            freq[nums[i]]+=1
        
        bucket = [[] for _ in range(len(nums)+1)]
        for key, val in freq.items():
            bucket[val].append(key)
        
        res = []
        for i in range(len(bucket)-1, 0, -1):
            for num in bucket[i]:
                res.append(num)
                if len(res) == k:
                    return res
        
        return res