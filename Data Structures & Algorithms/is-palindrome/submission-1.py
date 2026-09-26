class Solution:
    def isPalindrome(self, s: str) -> bool:
        i = 0
        j = len(s) -1 
        while i < j:
            ch1, ch2 = s[i], s[j]
            if not ch1.isalnum():
                i+=1
            elif not ch2.isalnum():
                j-=1
            else:
                if ch1.lower() == ch2.lower():
                    i+=1
                    j-=1
                else:
                    return False
        
        return True