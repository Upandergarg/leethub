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
  int fn(TreeNode root, int[] max){
if(root == null) return 0;

int l= fn(root.left,max);
int r= fn(root.right,max);
max[0]= Math.max(max[0],l+r);
return 1 + Math.max(l,r);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int [] ans= new int[1];
         fn(root,ans);
         return ans[0];
    }
}