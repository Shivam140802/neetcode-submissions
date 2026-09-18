class Solution:
    def calPoints(self, operations: List[str]) -> int:
        n=len(operations)
        arr=[]
        for i in range(n):
            if operations[i]=='C':
                arr.pop()
            elif operations[i]=='D':
                num=arr.pop()
                arr.append(num)
                arr.append(2*int(num))
            elif operations[i]=='+':
                num1=arr.pop()
                num2=arr.pop()
                arr.append(num2)
                arr.append(num1)
                arr.append(int(num1)+int(num2))
            else:
                arr.append(int(operations[i]))
        
        return sum(arr)