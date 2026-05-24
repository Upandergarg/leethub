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
    public int kthSmallest(TreeNode root, int k) {
        int cnt=0;
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left==null){
                cnt++;
                if(cnt==k) return cur.val;
                cur=cur.right;
            }
            else{
                TreeNode prv= cur.left;
                while(prv.right!=null && prv.right!=cur){
                    prv=prv.right;
                }
                if(prv.right==null){
                    prv.right=cur;
                    cur=cur.left;
                }
                else{
                    prv.right=null;
                    cnt++;
                    if(cnt==k) return cur.val;
                    cur=cur.right;
                }
            }
        }
        return -1;
    }
}