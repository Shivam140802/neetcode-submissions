class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = defaultdict(list)
        for st in strs:
            l =[0] *26
            for ch in st:
                l[ord(ch)- ord('a')]+=1
            
            d[tuple(l)].append(st)
        
        return list(d.values())