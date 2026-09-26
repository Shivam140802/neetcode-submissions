class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        st = ""
        n1 = len(word1)
        n2 = len(word2)
        n = min(n1, n2)
        for i in range(0, n):
            st += word1[i] + word2[i]
        
        if n1 > n:
            st += word1[n : n1]
        
        if n2 > n:
            st += word2[n : n2]
        
        return st