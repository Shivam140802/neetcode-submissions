class Solution {
    class Pair{
        String st;
        double val;
        Pair(String st, double val){
            this.st=st;
            this.val=val;
        }
    }
    public double dfs(HashMap<String, List<Pair>> map, String curr, String target, HashSet<String> vis, double ans){
        if(curr.equals(target)) return ans;
        vis.add(curr);
        for(Pair child: map.get(curr)){
            if(!vis.contains(child.st)){
                double result=dfs(map, child.st, target, vis, ans*child.val);
                if(result!=-1) return result;
            }
        }
        return -1;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n=values.length;
        HashMap<String, List<Pair>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            String st1=equations.get(i).get(0);
            String st2=equations.get(i).get(1);
            double num=values[i];
            map.putIfAbsent(st1, new ArrayList<>());
            map.putIfAbsent(st2, new ArrayList<>());
            map.get(st1).add(new Pair(st2, num));
            map.get(st2).add(new Pair(st1, 1.0/num));
        }
        double[] ans=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String st1=queries.get(i).get(0);
            String st2=queries.get(i).get(1);
            if(!map.containsKey(st1) || !map.containsKey(st2)){
                ans[i]=-1;
            }
            else if(st1.equals(st2)){
                ans[i]=1;
            }
            else{
                ans[i]=dfs(map, st1, st2, new HashSet<>(), 1.0);
            }
        }
        return ans;

    }
}