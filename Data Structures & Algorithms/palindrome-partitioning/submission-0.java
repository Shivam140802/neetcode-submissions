class Solution {
    public boolean check(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i+=1;
            j-=1;
        }
        return true;
    }
    public void Part(String s, List<List<String>> list, List<String> temp, int idx){
        if(idx==s.length()){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(check(s,idx, i)){
                temp.add(s.substring(idx, i+1));
                Part(s, list, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> list=new ArrayList<>();
        Part(s, list, new ArrayList<>(), 0);
        return list;
    }
}
