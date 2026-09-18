class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        hash_set=set()
        for i in range(len(nums)):
            for j in range(i+1,len(nums)):
                current_target=target-(nums[i]+nums[j])
                m,n=j+1,len(nums)-1
                while m<n:
                    if nums[m]+nums[n]==current_target:
                        hash_set.add(tuple([nums[i],nums[j],nums[m],nums[n]]))
                        n-=1
                        m+=1
                    elif nums[m]+nums[n]>current_target:
                        n-=1
                    else:
                        m+=1
        
        return list(hash_set)