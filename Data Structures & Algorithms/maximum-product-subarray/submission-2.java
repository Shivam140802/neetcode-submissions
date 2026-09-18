class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int max_pro=Integer.MIN_VALUE;
        int prefix=1;
        for(int i=0;i<n;i++){
            prefix*=nums[i];
            max_pro=Math.max(max_pro, prefix);
            if(prefix==0){
                prefix=1;
            }
        }
        int suffix=1;
        for(int i=n-1;i>=0;i--){
            suffix*=nums[i];
            max_pro=Math.max(max_pro, suffix);
            if(suffix==0){
                suffix=1;
            }
        }
        return max_pro;
    }
}
