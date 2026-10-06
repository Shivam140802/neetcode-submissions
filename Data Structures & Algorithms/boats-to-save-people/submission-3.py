class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
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