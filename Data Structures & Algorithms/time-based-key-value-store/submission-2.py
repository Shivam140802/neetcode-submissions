class TimeMap:

    def __init__(self):
        self.mapping=defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.mapping[key].append((value,timestamp))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.mapping:
            return ""
        arr=self.mapping[key]
        low,high=0,len(arr)-1
        while low<=high:
            mid=(low+high)//2
            if arr[mid][1]==timestamp:
                return arr[mid][0]
            elif arr[mid][1]>timestamp:
                high=mid-1
            else:
                low=mid+1
        
        return arr[high][0] if high>=0 else ""
