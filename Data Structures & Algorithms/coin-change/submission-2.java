class Solution {
    HashMap<String, Integer> map=new HashMap<>();
    public int Coin(int[] coins, int idx, int curr_amount, int amount){
        if(curr_amount==amount) return 0;
        if(curr_amount>amount || idx==coins.length) return Integer.MAX_VALUE/2;
        String key=idx+","+curr_amount;
        if(map.containsKey(key)) return map.get(key);
        int first_coin=1+Coin(coins, idx, curr_amount+coins[idx], amount);
        int second_coin=Coin(coins, idx+1, curr_amount, amount);
        int ans=Math.min(first_coin, second_coin);
        map.put(key, ans);
        return ans;
    }
    public int coinChange(int[] coins, int amount) {
        int res=Coin(coins, 0, 0, amount);
        return res==Integer.MAX_VALUE/2?-1:res;
    }
}
