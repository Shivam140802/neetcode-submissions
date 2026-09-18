class Solution {
    public void Perm(int[] nums ,List<List<Integer>> res, List<Integer> list, boolean[] used){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            list.add(nums[i]);
            Perm(nums, res, list, used);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Perm(nums ,res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
}
