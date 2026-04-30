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
   boolean isMirror(TreeNode root1, TreeNode root2){
    
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;

        if(root1!=null && root2!=null && root1.val!=root2.val) return false;
        return isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left,root.right);
    }
}

//think it as 
// for every pair in sysmtry from both sides we go check recursively and if both reaches null at same time we return true 
//and that true is going to store at that position and then will check for  the other part in recursive way unitl it gets its true we cant return true

// just sees the ex and see rootleft and rootright
//in recursive way 
// return false if u reach one null 
//return false if not equal
//resturn true if reach at same point