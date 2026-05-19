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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
int l= countLNodes(root);
int r= countRNodes(root);
if(l==r) return  (1<<l) -1;
return 1+ countNodes(root.left)+countNodes(root.right);
    }
    int countLNodes(TreeNode root){
int i=0;
while(root!=null){
    root=root.left;
    i++;
}
return i;
    }
    int countRNodes(TreeNode root){
int i=0;
while(root!=null){
    root=root.right;
    i++;
}
return i;
    }
}