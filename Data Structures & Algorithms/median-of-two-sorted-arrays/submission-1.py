class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1=len(nums1)
        n2=len(nums2)
        if n1>n2:
            return self.findMedianSortedArrays(nums2,nums1)
        low,high=0,n1
        while low<=high:
            nums1_partition=(low+high)//2
            nums2_partition=(n1+n2+1)//2-nums1_partition
            l1=float('-inf') if nums1_partition==0 else nums1[nums1_partition-1]
            r1=float('inf')if nums1_partition==n1 else nums1[nums1_partition]
            l2=float('-inf') if nums2_partition==0 else nums2[nums2_partition-1] 
            r2=float('inf')if nums2_partition==n2 else nums2[nums2_partition]

            if l1<=r2 and l2<=r1:
                if (n1+n2)%2==0:
                    return (max(l1,l2)+min(r1,r2))/2
                else:
                    return max(l1,l2)
            elif l1>r2:
                high=nums1_partition-1
            else:
                low=nums1_partition+1
        
        return 0.0
            