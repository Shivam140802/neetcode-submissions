class Solution {
    public void Word(String s, List<String> list, HashSet<String> set, int idx, List<String> temp){
        if(idx==s.length()){
            String str="";
            for(String st:temp){
                str+=(st+' ');
            }
            list.add(str.trim());
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(set.contains(s.substring(idx, i+1))){
                temp.add(s.substring(idx,i+1));
                Word(s, list, set, i+1, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>();
        for(String st:wordDict){
            set.add(st);
        }
        List<String> list =new ArrayList<>();
        Word(s, list, set, 0, new ArrayList<>());
        return list;
    }
}