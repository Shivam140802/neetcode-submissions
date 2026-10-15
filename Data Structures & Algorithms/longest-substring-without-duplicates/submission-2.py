class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        unique_ele = set()
        i, j = 0, 0
        max_len = 0
        while j<n and i<n:
            if not s[j] in unique_ele:
                unique_ele.add(s[j])
                max_len = max(max_len, j-i+1)
                j+=1
            else:
                unique_ele.remove(s[i])
                i+=1
        
        return max_len