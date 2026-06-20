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
    void fn(TreeNode root,List ans, String s){
        if(root==null) return;
if(root.left==null && root.right==null){
ans.add(s+root.val);
return;
}
fn(root.left,ans,s+root.val);
fn(root.right,ans,s+root.val);

    }
    public int sumNumbers(TreeNode root) {
        List<String> ans= new ArrayList<>();
        fn(root,ans,"");
        int a=0;
        for(String s: ans){
a+=Integer.parseInt(s);
        }
        return a;

    }
}