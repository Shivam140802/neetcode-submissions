class Solution:
    def do_operations(self,stack,ch):
        num1=stack.pop()
        num2=stack.pop()
        match ch:
            case '+':
                stack.append(num2+num1)
            case '-':
                stack.append(num2-num1)
            case '*':
                stack.append(num1*num2)
            case '/':
                stack.append(int(num2/num1))

    def evalRPN(self, tokens: List[str]) -> int:
        n=len(tokens)
        stack=[]
        for i in range(n):
            if tokens[i]=='+' or tokens[i]=='-' or tokens[i]=='/' or tokens[i]=='*':
                self.do_operations(stack,tokens[i])
            else:
                stack.append(int(tokens[i]))
        return stack[-1]