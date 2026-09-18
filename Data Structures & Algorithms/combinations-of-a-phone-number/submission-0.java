class Solution {
    public void Combo(String digits, HashMap<Integer, ArrayList<String>> map, List<String> temp, StringBuilder sb, int idx){
        if(idx==digits.length()){
            temp.add(sb.toString());
            return;
        }
        int num=digits.charAt(idx)-'0';
        for(int i=0;i<map.get(num).size();i++){
            sb.append(map.get(num).get(i));
            Combo(digits, map, temp, sb, idx+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, ArrayList<String>> map=new HashMap<>();
        map.put(2,new ArrayList<>(Arrays.asList("a","b", "c")));
        map.put(3,new ArrayList<>(Arrays.asList("d","e", "f")));
        map.put(4,new ArrayList<>(Arrays.asList("g","h", "i")));
        map.put(5,new ArrayList<>(Arrays.asList("j","k", "l")));
        map.put(6,new ArrayList<>(Arrays.asList("m","n", "o")));
        map.put(7,new ArrayList<>(Arrays.asList("p","q", "r","s")));
        map.put(8,new ArrayList<>(Arrays.asList("t","u", "v")));
        map.put(9,new ArrayList<>(Arrays.asList("w","x", "y","z")));
        List<String> list=new ArrayList<>();
        if(digits.length()==0) return list;
        Combo(digits, map, list, new StringBuilder(), 0);
        return list;
    }
}
