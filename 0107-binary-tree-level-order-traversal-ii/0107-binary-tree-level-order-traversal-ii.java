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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null) return ans;
        q.add(root);
    while(!q.isEmpty()){
        int size= q.size();
        List<Integer> l= new ArrayList<>();
        while(size-->0){
            TreeNode t= q.poll();
            l.add(t.val);
            if(t.left!=null) q.add(t.left);
            if(t.right!=null) q.add(t.right);
        }
        ans.add(0,l);
    }   
    return ans;
     }
}