# class Node:
#     def __init__(self, data: int):
#         self.data= data
#         self.next= None

class MyHashSet:

    def __init__(self):
        self.bucket = [False]*(10**6+1)

    def add(self, key: int) -> None:
        self.bucket[key] = True

    def remove(self, key: int) -> None:
        self.bucket[key] = False

    def contains(self, key: int) -> bool:
        return self.bucket[key]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)