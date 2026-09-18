class Solution:
    def simplifyPath(self, path: str) -> str:
        st=[p for p in path.split('/') if p]
        stack=[]
        for s in st:
            if s=='..':
                if stack:
                    stack.pop()
            elif s!='.':
                stack.append(s)
        
        return '/'+'/'.join(stack)