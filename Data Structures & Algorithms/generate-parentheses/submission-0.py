class Solution:
    def generate(self,arr,open_count,close_count,st):
        if close_count==0 and open_count==0:
            arr.append(st)
            return
        if open_count>0:
            self.generate(arr,open_count-1,close_count,st+'(')
        if close_count>open_count:
            self.generate(arr,open_count,close_count-1,st+')')
    def generateParenthesis(self, n: int) -> List[str]:
        arr=[]
        self.generate(arr,n,n,"")
        return arr