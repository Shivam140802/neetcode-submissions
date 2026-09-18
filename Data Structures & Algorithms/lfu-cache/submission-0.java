class LFUCache {
    class Node{
        int key,val,freq;
        Node(int key,int val){
            this.key=key;
            this.val=val;
            this.freq=1;
        }
    }
    HashMap<Integer,LinkedHashSet<Node>> freq_map;
    HashMap<Integer,Node> add_map;
    int capacity,min_freq;
    public LFUCache(int capacity) {
        this.min_freq=0;
        this.capacity=capacity;
        this.freq_map=new HashMap<>();
        this.add_map=new HashMap<>();
    }
    public int get(int key) {
        if(!add_map.containsKey(key)) return -1;
        Node node=add_map.get(key);
        update_freq(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;
        if(add_map.containsKey(key)){
            Node node=add_map.get(key);
            node.val=value;
            update_freq(node);
        }
        else{
            if(add_map.size()>=capacity){
                LinkedHashSet<Node> minSet=freq_map.get(min_freq);
                Node node=minSet.iterator().next();
                minSet.remove(node);
                add_map.remove(node.key);
            }
            Node newnode=new Node(key,value);
            add_map.put(key,newnode);
            freq_map.computeIfAbsent(1,k->new LinkedHashSet<>()).add(newnode);
            min_freq=1;
        }
    }
    public void update_freq(Node node){
        int old_freq=node.freq;
        LinkedHashSet<Node> set=freq_map.get(old_freq);
        set.remove(node);
        if(set.isEmpty() && min_freq==old_freq){
            min_freq+=1;
        }
        node.freq++;
        freq_map.computeIfAbsent(node.freq,k->new LinkedHashSet<>()).add(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */