class PrefixTree {
    class TrieNode{
        boolean isEnd;
        TrieNode[] nodes;
        TrieNode(boolean isEnd, TrieNode[] nodes){
            this.isEnd=isEnd;
            this.nodes=nodes;
        }
    }
    TrieNode root;
    public PrefixTree() {
        root=new TrieNode(false, new TrieNode[26]);
    }

    public void insert(String word) {
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if(curr.nodes[idx]==null)
                curr.nodes[idx]=new TrieNode(false, new TrieNode[26]);
            curr=curr.nodes[idx];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if(curr.nodes[idx]!=null){
                curr=curr.nodes[idx];
            }
            else{
                return false;
            }
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(char ch: prefix.toCharArray()){
            int idx=ch-'a';
            if(curr.nodes[idx]!=null){
                curr=curr.nodes[idx];
            }
            else{
                return false;
            }
        }
        return true;
    }
}
