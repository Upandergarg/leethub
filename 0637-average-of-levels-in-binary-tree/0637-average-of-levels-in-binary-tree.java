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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q   = new LinkedList<>();
          List<Double> ans= new ArrayList<>();
        if(root==null) return ans;
        q.offer(root);
      
        while(!q.isEmpty()){
            double i=0;
        double sum=0;
            int size=  q.size();
            while(size-->0){
                TreeNode t=q.poll();
                sum+=t.val;
                i++;
                if(t.left!=null) q.offer(t.left);
                if(t.right!=null) q.offer(t.right);
            }

ans.add(sum/i);
        }
        return ans;
    }
}