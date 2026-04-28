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
    public List<Integer> largestValues(TreeNode root) {
           Queue<TreeNode> q= new LinkedList<>();
        List<Integer> ans= new ArrayList<>();
        if(root==null) return ans;
        q.add(root);
    while(!q.isEmpty()){
        int size= q.size();
        int p= Integer.MIN_VALUE;
        while(size-->0){
            TreeNode t= q.poll();
            p= Math.max(p,t.val);
            if(t.left!=null) q.add(t.left);
            if(t.right!=null) q.add(t.right);
        }
        ans.add(p);
    }   
    return ans;
    }
}