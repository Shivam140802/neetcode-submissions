class Solution {
    public int Xor(int[] nums, int index, int currXor){
        if(index==nums.length){
            return currXor;
        }
        int include=Xor(nums, index+1, currXor^nums[index]);
        int exclude=Xor(nums, index+1, currXor);
        return include+exclude;
    }
    public int subsetXORSum(int[] nums) {
        return Xor(nums,0, 0);
    }
}