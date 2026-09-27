class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        res_arr = []
        i, j= 0, 0
        while i<m and j<n:
            if nums1[i] <= nums2[j]:
                res_arr.append(nums1[i])
                i+=1
            else:
                res_arr.append(nums2[j])
                j+=1
        
        while i<m:
            res_arr.append(nums1[i])
            i+=1
        
        while j<n:
            res_arr.append(nums2[j])
            j+=1
        
        for i in range(0, len(nums1)):
            nums1[i] = res_arr[i]

        return res_arr