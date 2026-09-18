class Solution:
    def isValid(self, s: str) -> bool:
        n=len(s)
        arr=[]
        for i in range(n):
            if s[i]==']':
                if arr and arr[-1]=='[':
                    arr.pop()
                else:
                    return False
            elif s[i]=='}':
                if arr and arr[-1]=='{':
                    arr.pop()
                else:
                    return False
            elif s[i]==')':
                if arr and arr[-1]=='(':
                    arr.pop()
                else:
                    return False
            else:
                arr.append(s[i])
        
        return True if len(arr)==0 else False