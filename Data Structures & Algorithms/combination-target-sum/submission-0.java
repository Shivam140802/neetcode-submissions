class Solution {
    public void Sub(int[] nums, List<List<Integer>> list, List<Integer> temp, int index, int currSum, int target){
        if(currSum>=target){
            if(currSum==target) list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            Sub(nums, list, temp, i, currSum+nums[i], target);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        Sub(nums, list, new ArrayList<Integer>(), 0, 0, target);
        return list;
    }
}
