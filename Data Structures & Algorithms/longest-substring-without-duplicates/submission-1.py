class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n=len(s)
        left=0
        max_len=0
        hash_set=set()
        for right in range(n):
            while s[right] in hash_set:
                hash_set.remove(s[left])
                left+=1
            hash_set.add(s[right])
            max_len=max(max_len,right-left+1)
        return max_len