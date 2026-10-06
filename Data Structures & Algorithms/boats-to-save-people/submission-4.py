class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        m = max(people)
        count = [0] * (m+1)
        for p in people:
            count[p]+=1

        i, j = 0, 0
        while j < len(people):
            while count[i] == 0:
                i+=1
            people[j] = i
            count[i] -=1
            j+=1

        i, j = 0, len(people)-1
        count = 0

        while i <= j:
            if people[i] + people[j] <= limit:
                i+=1
                j-=1
            else:
                if people[i] <= people[j]:
                    j-=1
                else:
                    i+=1
            count+=1
        
        return count