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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
          if(preorder.length!=inorder.length) return null;
HashMap<Integer,Integer> map= new HashMap<>();
for(int i=0; i<inorder.length; i++){
    map.put(inorder[i],i);
}
     return  inToPre(inorder,0,inorder.length-1,preorder,0,preorder.length-1,map);
    }
  TreeNode  inToPre(int[] in,int is,int ie, int[] pre,int ps,int pe,HashMap<Integer,Integer> map){
if(ie<is || ps>pe  ) return null;


TreeNode root=new TreeNode(pre[ps]);
int instart= map.get(root.val);
int numsleft= instart-is;

root.left=inToPre(in,is,instart-1,pre,ps+1,ps+numsleft,map);
root.right=inToPre(in,instart+1,ie,pre,ps+numsleft+1,pe,map);
return root;


    }
}