class Solution {
    public boolean dfs(int[] match, int[] sides, int target, int idx){
        if(idx==match.length){
            return sides[1]==sides[2] && sides[1]==sides[2] && sides[2]==sides[3];
        }
        for(int i=0;i<4;i++){
            if(sides[i]+match[idx]>target) continue;
            sides[i]+=match[idx];
            if(dfs(match, sides, target, idx+1)) return true;
            sides[i]-=match[idx];
        }
        return false;
    }
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int num:matchsticks) sum+=num;
        if(sum%4!=0) return false;

        int target=sum/4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[] sides=new int[4];
        return dfs(matchsticks, sides, target,0);
    }
    public void reverse(int[] arr){
        for(int i=0,j=arr.length-1;i<j;i++,j--){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
}