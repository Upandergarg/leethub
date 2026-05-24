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
    int cnt=0;
    void fn(TreeNode root,int k,int ans[]){
        if(root==null) return;
        fn(root.left,k,ans);
        cnt++;
        if(cnt==k) {
            ans[0]=root.val;
        }
        fn(root.right,k,ans);
    }
    public int kthSmallest(TreeNode root, int k) {
       int [] ans= new int[1];
    fn(root,k,ans);
    return ans[0];
    }
}