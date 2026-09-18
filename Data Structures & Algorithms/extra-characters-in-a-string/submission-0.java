class Trie{
    class TrieNode{
        TrieNode[] node;
        boolean isEnd;
        public TrieNode(TrieNode[] node, boolean isEnd){
            this.node=node;
            this.isEnd=isEnd;
        }
    }
    TrieNode root;
    Trie(){
        this.root=new TrieNode(new TrieNode[26], false);
    }
    public void insert(String s){
        TrieNode curr=root;
        for(char ch:s.toCharArray()){
            int idx=ch-'a';
            if(curr.node[idx]==null){
                curr.node[idx]=new TrieNode(new TrieNode[26], false);
            }
            curr=curr.node[idx];
        }
        curr.isEnd=true;
    }
    public boolean search(String s){
        TrieNode curr=root;
        for(char ch:s.toCharArray()){
            int idx=ch-'a';
            if(curr.node[idx]!=null){
                curr=curr.node[idx];
            }
            else{
                return false;
            }
        }
        return curr.isEnd;
    }

}
class Solution {
    int[] dp;
    public int findMin(String s, int i, Trie trie){
        if(i==s.length()) return 0;
        if(dp[i]!=-1) return dp[i];
        int result=1+findMin(s, i+1, trie);
        for(int j=i;j<s.length();j++){
            if(trie.search(s.substring(i,j+1))){
                result=Math.min(result, findMin(s, j+1, trie));
            }
        }
        return dp[i]=result;
    }
    public int minExtraChar(String s, String[] dictionary) {
        dp=new int[s.length()];
        Arrays.fill(dp,-1);
        Trie trie=new Trie();
        for(String st:dictionary){
            trie.insert(st);
        }
        return findMin(s, 0, trie);
    }
}