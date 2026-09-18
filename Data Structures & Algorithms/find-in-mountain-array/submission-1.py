class Solution:
    def find_peak(self,mountainArr):
        low,high=0,mountainArr.length()-1
        while low<high:
            mid=(low+high)//2
            if mountainArr.get(mid)<mountainArr.get(mid+1):
                low=mid+1 
            else:
                high=mid
        return low
    def binarySearch1(self,low,high,mountainArr,target):
        while low<=high:
            mid=(low+high)//2
            if mountainArr.get(mid)==target:
                return mid
            elif mountainArr.get(mid)>target:
                high=mid-1
            else:
                low=mid+1
        return -1
    def binarySearch2(self,low,high,mountainArr,target):
        while low<=high:
            mid=(low+high)//2
            if mountainArr.get(mid)==target:
                return mid
            elif mountainArr.get(mid)>target:
                low=mid+1
            else:
                high=mid-1
        return -1
    def findInMountainArray(self, target: int, mountainArr: 'MountainArray') -> int:
        peak_idx=self.find_peak(mountainArr)
        num1=self.binarySearch1(0,peak_idx,mountainArr,target)
        num2=self.binarySearch2(peak_idx+1,mountainArr.length()-1,mountainArr,target)

        if num1!=-1:
            return num1
        if num2!=-1:
            return num2
        
        return -1