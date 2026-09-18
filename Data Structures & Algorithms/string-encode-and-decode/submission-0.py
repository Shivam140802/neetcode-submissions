class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded_st=''.join(f'{len(s)}#{s}' for s in strs)
        return encoded_st
    def decode(self, s: str) -> List[str]:
        decoded_st=[]
        i=0
        while i<len(s):
            j=i
            while s[j]!='#':
                j+=1
            length=int(s[i:j])
            j+=1
            decoded_st.append(s[j:j+length])
            i=j+length
        
        return decoded_st
