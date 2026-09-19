class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded = []
        for st in strs:
            encoded.append(str(len(st)))
            encoded.append("#")
            encoded.append(st)
        
        return "".join(encoded)

    def decode(self, s: str) -> List[str]:
        decoded_st = []
        i = 0
        while i< len(s):
            j = i
            while s[j] != '#':
                j+=1
            length = int(s[i:j])
            j+=1
            decoded_st.append(s[j:j+length])
            i = j + length
        
        return decoded_st