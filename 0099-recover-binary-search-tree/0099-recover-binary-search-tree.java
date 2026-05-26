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
  public  TreeNode f=null;
  public  TreeNode s=null;
  public  TreeNode m=null;
  TreeNode p=null;
   public void find(TreeNode root){
if(root==null) return;
find(root.left);

if(p!=null){
if(p.val>root.val){
    if(f!=null){
       s=root;
    }
    else {
          m=root;
        f=p;
    }
}
}
 p=root;


find(root.right);
    }
    public void recoverTree(TreeNode root) {
        
        find(root);
       
         System.out.print(f.val);
           System.out.print(m.val);
        if(s!=null){
            int t= f.val;
            f.val= s.val;
              System.out.print(f.val);
            s.val=t;
        }
        else{
           int t=f.val;
           f.val= m.val;
             System.out.print(f.val);
           m.val=t; 
        }
       
    }
}