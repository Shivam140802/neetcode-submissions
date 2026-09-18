/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // public void dfs(Node node, Node root, HashMap<Node, Node> map){
    //     for(Node ptr: node.neighbors){
    //         if(map.containsKey(ptr)){
    //             root.neighbors.add(map.get(ptr));
    //         }
    //         else{
    //             Node clone=new Node(ptr.val);
    //             map.put(ptr, clone);
    //             root.neighbors.add(clone);
    //             dfs(ptr, clone, map);
    //         }
    //     }
    // }
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node, Node> map=new HashMap<>();
        Node root=new Node(node.val);
        map.put(node, root);
        Queue<Node> q=new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            Node curr=q.poll();
            for(Node ptr: curr.neighbors){
                if(!map.containsKey(ptr)){
                    Node clone=new Node(ptr.val);
                    map.put(ptr, clone);
                    q.offer(ptr);
                }
                map.get(curr).neighbors.add(map.get(ptr));
            }
        }
        return root;
    }
}