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
class Solution {

  class f{
        Stack<TreeNode> s= new Stack<>();
        boolean flag;
        public f(TreeNode t,boolean f){
             flag=f;
            push(t);
           
        }
        void push(TreeNode r){
            while(r!=null){
                s.push(r);
                if(flag) r=r.left;
                else r=r.right;
            }
        }
        int next(){
            TreeNode n=s.pop();
            if(flag) push(n.right);
            else push(n.left);
            return n.val;
        }
  }

    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        f l= new f(root,true);
        f r= new f(root,false);
        int i= l.next();
        int j= r.next();
        while(i<j){
            int sum= i+j;
            if(sum==k) return true;
            else if(sum>k) j=r.next();
            else i= l.next();
        }
        return false;
    }
}