class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        sorted_word=[''.join(sorted(word)) for word in strs]
        d=defaultdict(list)
        for i in range(len(strs)):
            d[sorted_word[i]].append(strs[i])
        
        return list(d.values())