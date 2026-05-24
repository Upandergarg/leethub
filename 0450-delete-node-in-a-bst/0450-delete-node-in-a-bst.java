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
    TreeNode rightMost(TreeNode root){
        if(root.right==null) return root;
    return rightMost(root.right);
    }
    TreeNode help(TreeNode root){
if(root.left==null) return root.right;
else if(root.right==null) return root.left;
else{
    TreeNode rightOne= root.right;
    TreeNode rightMostOfLeft= rightMost(root.left);
    rightMostOfLeft.right=rightOne;
    return root.left;
}
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key) return help(root);
        TreeNode cur=root;
        while(cur!=null){
            if(cur.val>key){
                if(cur.left!=null && cur.left.val==key){
                    cur.left=help(cur.left);
                    break;
                }
                else cur=cur.left;
            }
            else{
                if(cur.right!=null && cur.right.val==key){
                    cur.right=help(cur.right);
                    break;
                }
                else cur=cur.right;
            }
        }
        return root;
    }
}