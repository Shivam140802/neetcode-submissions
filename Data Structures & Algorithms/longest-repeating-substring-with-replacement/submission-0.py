class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        n=len(s)
        arr=[0]*26
        left=0
        max_len,max_freq=0,0
        for right in range(len(s)):
            arr[ord(s[right])-ord('A')]+=1
            max_freq=max(arr[ord(s[right])-ord('A')],max_freq)
            while right-left+1-max_freq>k:
                arr[ord(s[left])-ord('A')]-=1
                max_freq=0
                for i in range(26):
                    max_freq=max(max_freq,arr[i])
                left+=1
            
            max_len=max(max_len,right-left+1)
        
        return max_len