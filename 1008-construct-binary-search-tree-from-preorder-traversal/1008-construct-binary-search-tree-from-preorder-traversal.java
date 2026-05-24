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
    TreeNode fn(int[] p,int u,int[] i){
        if(i[0]>p.length-1 || p[i[0]]>u) return null;
           TreeNode root=new TreeNode(p[i[0]++]);
        root.left= fn(p,root.val,i);
        root.right= fn(p,u,i);
         return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
       
   int []i=new int[1];
        return fn(preorder,Integer.MAX_VALUE,i);
    }
}