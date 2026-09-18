class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        hash_set=set()
        nums.sort()
        for i in range(len(nums)):
            target=0-nums[i]
            j,k=i+1,len(nums)-1
            while j<k:
                if nums[j]+nums[k]==target:
                    hash_set.add(tuple([nums[i],nums[j],nums[k]]))
                    k-=1
                    j+=1
                elif nums[j]+nums[k]>target:
                    k-=1
                else:
                    j+=1
        
        return list(hash_set)