class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n=len(s)
        max_len=0
        for i in range(n):
            hash_set=set()
            hash_set.add(s[i])
            j=i+1
            while j<n and not s[j] in hash_set:
                hash_set.add(s[j])
                j+=1
            max_len=max(max_len,j-i)
        
        return max_len
            