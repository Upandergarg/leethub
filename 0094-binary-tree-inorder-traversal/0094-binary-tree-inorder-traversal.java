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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
      
        TreeNode cur = root;
        while (true) {
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            else{
                if(s.isEmpty()) break;
                cur= s.pop();
                ans.add(cur.val);
                cur= cur.right;
            }
        }
        return ans;
    }
}