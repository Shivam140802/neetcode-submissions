class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        n1,n2=len(word1),len(word2)
        i=0
        s=""
        while i<(min(n1,n2)):
            s+=word1[i]+word2[i]
            i+=1
        while i<n1:
            s+=word1[i]
            i+=1
        
        while i<n2:
            s+=word2[i]
            i+=1
        
        return s

