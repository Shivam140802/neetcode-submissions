class Solution:
    def decodeString(self, s: str) -> str:
        n=len(s)
        stack=[]
        curr_st=""
        num=0
        for ch in s:
            if ch.isdigit():
                num=num*10+int(ch)
            elif ch=='[':
                stack.append((curr_st,num))
                curr_st=''
                num=0
            elif ch==']':
                prev_st,repeat=stack.pop()
                curr_st=prev_st+(repeat*curr_st)
            else:
                curr_st+=ch
        
        return curr_st