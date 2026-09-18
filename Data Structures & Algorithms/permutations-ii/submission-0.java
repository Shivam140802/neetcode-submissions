class Solution {
    public void Perm(int[] nums, HashSet<List<Integer>> res, List<Integer> list, boolean[] used){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            list.add(nums[i]);
            used[i]=true;
            Perm(nums, res, list, used);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> res=new HashSet<>();
        Perm(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return new ArrayList<>(res);
    }
}