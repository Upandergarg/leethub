/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> s= new Stack<>();
    public BSTIterator(TreeNode root) {
        push(root);
    }

    void push(TreeNode node){
        while(node!=null){
            s.push(node);
            node=node.left;
        }
    }
    
    public int next() {
       TreeNode t=s.pop();
        push(t.right);
        return t.val;
    }
    
    public boolean hasNext() {
       return !s.isEmpty();
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */