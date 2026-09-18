class MyStack:

    def __init__(self):
        self.queue=deque()
        self.top_ele=0
    def push(self, x: int) -> None:
        self.queue.append(x)
        self.top_ele=x

    def pop(self) -> int:
        n=len(self.queue)-1
        count=0
        while count<n:
            self.top_ele=self.queue.popleft()
            self.queue.append(self.top_ele)
            count+=1
        return self.queue.popleft()

    def top(self) -> int:
        return self.top_ele

    def empty(self) -> bool:
        return True if len(self.queue)==0 else False


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()