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
    class w{
        int min;
        int max;
        int sum;
        w(int min,int max,int sum){
this.min=min;
this.max=max;
this.sum=sum;
        }
    }
    int ans=0;
    w fn(TreeNode root){
if(root==null) return new w(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
w l= fn(root.left);
w r= fn(root.right);

if(root.val>l.max && root.val<r.min){
    ans= Math.max(ans,root.val+l.sum+r.sum);
return new w(Math.min(l.min,root.val),Math.max(r.max,root.val),root.val+l.sum+r.sum);
}
return new w(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
    }
    public int maxSumBST(TreeNode root) {
      fn(root);
        return ans>0?ans:0;
    }
}


///same as largert bst in bt, but here sum should be global and u should maintain it , rest same
