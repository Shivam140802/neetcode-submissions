class Solution:
    def right_side(self, s, i, j):
        while i < len(s) and j > 0 and i < j:
            if s[i] != s[j]:
                return False
            
            i+=1
            j-=1
        
        return True

    def left_side(self, s, i, j):
        while i < len(s) and j > 0 and i < j:
            if s[i] != s[j]:
                return False
            i+=1
            j-=1
        return True

    def validPalindrome(self, s: str) -> bool:
        count = 0
        i, j = 0, len(s)-1
        while i < j:
            if s[i] != s[j]:
                return self.right_side(s, i+1, j) or self.left_side(s, i, j-1)
            i += 1
            j -= 1
        
        return True