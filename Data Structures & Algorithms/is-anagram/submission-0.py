class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s)!=len(t):
            return False
        dict_s={}
        dict_t={}
        for ch1,ch2 in zip(s,t):
            dict_s[ch1]=dict_s.get(ch1,0)+1
            dict_t[ch2]=dict_t.get(ch2,0)+1
        
        return dict_s==dict_t