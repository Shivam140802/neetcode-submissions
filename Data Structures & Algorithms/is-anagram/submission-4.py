class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        freq={}
        for ch in s:
            if ch in freq:
                freq[ch]+=1
            else:
                freq[ch]=1

        for ch in t:
            if ch in freq and freq[ch]!=0:
                freq[ch]-=1
            else:
                return False

        return True  