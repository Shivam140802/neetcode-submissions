class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        n1=len(s1)
        n2=len(s2)
        if n1>n2:
            return False
        arr1=[0]*26
        arr2=[0]*26
        left,right=0,0
        for i in range(n1):
            arr1[ord(s1[i])-ord('a')]+=1
            arr2[ord(s2[i])-ord('a')]+=1
            right+=1
        right-=1
        while right<n2:
            if arr1==arr2:
                return True
            right+=1
            if right!=n2:
                arr2[ord(s2[right])-ord('a')]+=1
            arr2[ord(s2[left])-ord('a')]-=1
            left+=1
        
        return False
            