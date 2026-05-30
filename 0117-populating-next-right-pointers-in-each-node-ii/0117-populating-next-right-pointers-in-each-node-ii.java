/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Node> q= new LinkedList<>();
        q.offer(root);
        root.next=null;
        while(!q.isEmpty()){
            int s= q.size();
            Queue<Node> qt= new LinkedList<>();
            while(s-->0){
                Node t=q.poll();
                    
                if(t.left!=null) {
                    q.offer(t.left);
                    qt.offer(t.left);
                }
                if(t.right!=null){
                    q.offer(t.right);
                    qt.offer(t.right);
                }
                
            }
            while(!qt.isEmpty()){
                qt.poll().next=qt.peek();
            }
        }
        return root;
    }
}