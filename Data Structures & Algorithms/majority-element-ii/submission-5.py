class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        count1=count2=0
        ele1=ele2=10**10
        for num in nums:
            if count1==0 and num!=ele2:
                count1+=1
                ele1=num
            elif count2==0 and num!=ele1:
                count2+=1
                ele2=num
            elif num==ele1:
                count1+=1
            elif num==ele2:
                count2+=1
            else:
                count1-=1
                count2-=1
        res=[]
        count1=count2=0
        for num in nums:
            if ele1==num:
                count1+=1
            if ele2==num:
                count2+=1
        if count1>(len(nums)//3):
            res.append(ele1)
        if count2>(len(nums)//3):
            res.append(ele2)
        return res