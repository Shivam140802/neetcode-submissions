class FreqStack:

    def __init__(self):
        self.num_stack=defaultdict(list)
        self.freq={}
        self.max_freq=-1

    def push(self, val: int) -> None:
        self.freq[val]=self.freq.get(val,0)+1
        curr_freq=self.freq[val]
        self.num_stack[curr_freq].append(val)
        self.max_freq=max(self.max_freq,curr_freq)

    def pop(self) -> int:
        max_freq_ele=self.num_stack[self.max_freq].pop()
        if not self.num_stack[self.max_freq]:
            del self.num_stack[self.max_freq]
            self.max_freq-=1
        self.freq[max_freq_ele]-=1
        if self.freq[max_freq_ele]==0:
            del self.freq[max_freq_ele]
        
        return max_freq_ele
        


# Your FreqStack object will be instantiated and called as such:
# obj = FreqStack()
# obj.push(val)
# param_2 = obj.pop()