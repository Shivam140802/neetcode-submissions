class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded = ""
        for st in strs:
            encoded+="!"
            for ch in st:
                encoded +=str(ord(ch))
                encoded +="!"
            
        return encoded

    def decode(self, s: str) -> List[str]:
        result = []
        i = 0
        while i<len(s):
            i += 1
            st = ""
            while i < len(s) and s[i]!="!":
                num = 0
                while i < len(s) and s[i] != "!":
                    num = num *10 + int(s[i])
                    i+=1
                
                st  += chr(num)
                i+=1
            result.append(st)
        
        return result