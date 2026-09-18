class Trie{
    class TrieNode{
        boolean isEnd;
        TrieNode[] nodes;
        TrieNode(boolean isEnd, TrieNode[] nodes){
            this.isEnd=isEnd;
            this.nodes=nodes;
        }
    }
    TrieNode root;
    Trie(){
        this.root=new TrieNode(false, new TrieNode[26]);
    }
    public void insert(String st){
        TrieNode curr=root;
        for(char ch:st.toCharArray()){
            int idx=ch-'a';
            if(curr.nodes[idx]==null){
                curr.nodes[idx]=new TrieNode(false, new TrieNode[26]);
            }
            curr=curr.nodes[idx];
        }
        curr.isEnd=true;
    }
}
class WordDictionary {
    Trie trie;
    public WordDictionary() {
        trie=new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }
    public boolean search(String word) {
        return Match(trie.root, word, 0);
    }
    public boolean Match(Trie.TrieNode root, String word, int pos){
        if(root==null) return false;
        if(pos==word.length()) return root.isEnd;

        char ch=word.charAt(pos);
        if(ch=='.'){
            for(int i=0;i<26;i++){
                if(root.nodes[i]!=null && Match(root.nodes[i], word, pos+1))
                    return true;
            }
            return false;
        }
        else{
            int idx=ch-'a';
            return Match(root.nodes[idx], word, pos+1);
        }
    }
}
