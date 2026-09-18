class Solution {
    public void Sub(int[] nums, List<List<Integer>> list, List<Integer> temp, int index){
        if(index==nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        Sub(nums, list, temp, index+1);
        temp.remove(temp.size()-1);
        Sub(nums, list, temp, index+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Sub(nums, list, new ArrayList<Integer>(), 0);
        return list;
    }
}
