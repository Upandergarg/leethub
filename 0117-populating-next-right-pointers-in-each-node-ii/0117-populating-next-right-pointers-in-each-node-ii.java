

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        root.next = null;
        while (!q.isEmpty()) {
            int s = q.size();
             Node prv=null;
            while (s-- > 0) {
                Node t = q.poll();
if(prv!=null) prv.next=t;
prv=t;
                if (t.left != null) {
                    q.offer(t.left);
                    
                }
                if (t.right != null) {
                    q.offer(t.right);
                  
                }


            }
            prv.next=null;
           
        }
        return root;
    }
}