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
boolean fn(TreeNode root,int targetSum){
    if(root==null ) return false;
        if(root.left==null && root.right==null){
            if(targetSum-root.val==0) return true;
            return false;
        }
        return fn(root.left,targetSum-root.val) || fn(root.right,targetSum-root.val);
}
    public boolean hasPathSum(TreeNode root, int targetSum) {
    
if(root==null) return false;
return fn(root,targetSum);
    }
}