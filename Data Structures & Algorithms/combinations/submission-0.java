class Solution {
    public void Combo(List<List<Integer>> res, List<Integer> list, int n, int k, int num){
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        if(num>n) return;
        list.add(num);
        Combo(res, list, n, k, num+1);
        list.remove(list.size()-1);
        Combo(res, list, n, k, num+1);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res= new ArrayList<>();
        Combo(res, new ArrayList<>(), n, k, 1);
        return res;
    }
}