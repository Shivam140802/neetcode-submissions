class Trie{
    class TrieNode{
        TrieNode[] node;
        boolean isEnd;
        String word;
        TrieNode(){
            this.node=new TrieNode[26];
            this.isEnd=false;
            this.word="";
        }
    }
    TrieNode root;
    Trie(){
        this.root=new TrieNode();
    }
    public void insert(String s){
        TrieNode curr=root;
        for(char ch: s.toCharArray()){
            int idx=ch-'a';
            if(curr.node[idx]==null){
                curr.node[idx]=new TrieNode();
            }
            curr=curr.node[idx];
        }
        curr.isEnd=true;
        curr.word=s;
    }
}
class Solution {
    int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
    public void dfs(char[][] board, int i, int j, List<String> list, Trie.TrieNode root){
        char ch=board[i][j];
        int idx=ch-'a';
        if(ch=='#' || root.node[idx]==null) return;
        Trie.TrieNode next=root.node[idx];
        if(next.isEnd){
            list.add(next.word);
            next.isEnd=false;
        }
        board[i][j]='#';
        for(int[] arr:dir){
            int new_i=arr[0]+i;
            int new_j=arr[1]+j;
            if(new_i>=0 && new_j>=0 && new_i<board.length && new_j<board[0].length){
                dfs(board, new_i, new_j, list, next);
            }
        }
        board[i][j]=ch;
    }
    public List<String> findWords(char[][] board, String[] words) {
        int n=board.length;
        int m=board[0].length;
        Trie trie=new Trie();
        for(String s: words){
            trie.insert(s);
        }
        List<String> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(board, i, j, list, trie.root);
            }
        }
        return list;
    }
}
