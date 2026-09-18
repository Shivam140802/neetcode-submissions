class Solution {
    public int gcd(int a, int b){
        if(b>a) gcd(b,a);
        if(b==0) return a;
        return gcd(b, a%b);
    }
    public boolean canTraverseAllPairs(int[] nums) {
        int n=nums.length;
        boolean[] check=new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(gcd(nums[i], nums[j])>1){
                    check[i]=true;
                    check[j]=true;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(!check[i]) return false;
        }
        return true;
    }
}