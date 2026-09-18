class Solution {
    public void Combo(int[] candidates, HashSet<List<Integer>> set, List<Integer> list, int target, int sum, int index){
        if(index==candidates.length){
            if(sum==target){
                set.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(candidates[index]);
        Combo(candidates, set, list, target, sum+candidates[index], index+1);
        list.remove(list.size()-1);
        Combo(candidates, set, list, target, sum, index+1);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> set=new HashSet<>();
        Combo(candidates, set,new ArrayList<>(), target, 0, 0);
        return new ArrayList<>(set);
    }
}
