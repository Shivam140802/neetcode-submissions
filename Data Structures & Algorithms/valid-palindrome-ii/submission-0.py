class Solution:
    def check(self,s,ind):
        i,j=0,len(s)-1
        while i<j:
            if i==ind:
                i+=1
            elif j==ind:
                j-=1
            else:
                if s[i]!=s[j]:
                    return False
                i+=1
                j-=1
        return True
    def validPalindrome(self, s: str) -> bool:
        n=len(s)
        i,j=0,n-1
        while i<j:
            if s[i]==s[j]:
                i+=1
                j-=1
            else:
                if self.check(s,i) or self.check(s,j):
                    return True
                else:
                    return False
        
        return True