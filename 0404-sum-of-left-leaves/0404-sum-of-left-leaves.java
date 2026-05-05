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
    void su(TreeNode root,boolean f,int[] sum){
if(root ==null) return;
if(f){
  if(root.left==null && root.right==null) sum[0]+=root.val;
}
su(root.left,true,sum);
su(root.right,false,sum);
    }
    public int sumOfLeftLeaves(TreeNode root) {
      int [] sum= new int[1];
      if(root==null) return -1;
      if(root.left==null && root.right==null) return 0;
      su(root,false,sum);
      return sum[0];
    }
}