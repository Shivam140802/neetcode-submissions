class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        paired=list(zip(position,speed))
        paired.sort(reverse=True)
        no_fleet=0
        curr_time=0
        for pos,spd in paired:
            time=(target-pos)/spd
            if time>curr_time:
                no_fleet+=1
                curr_time=time
        
        return no_fleet