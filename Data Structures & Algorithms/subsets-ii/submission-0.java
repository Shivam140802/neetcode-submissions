class Solution {
    public void Sub(int[] nums, HashSet<List<Integer>> res, List<Integer> list, int idx){
        if(idx==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[idx]);
        Sub(nums, res, list, idx+1);
        list.remove(list.size()-1);
        Sub(nums, res, list, idx+1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> res=new HashSet<>();
        Arrays.sort(nums);
        Sub(nums, res, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }
}
