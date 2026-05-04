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
    public int findBottomLeftValue(TreeNode root) {
          Queue<TreeNode> q= new LinkedList<>();
      int l=0;
        
        q.offer(root);
        while(!q.isEmpty()){
            int size= q.size();
           int i=size;
            while(i-->0){
                
                 TreeNode t= q.poll();
                 if(i==size-1) l=t.val;
                
if(t.left!=null) q.add(t.left);
if(t.right!=null) q.add(t.right);
            }
          
        }
        return l;
    }
}

//just follow level order traversal