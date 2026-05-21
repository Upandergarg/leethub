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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
      if(postorder.length!=inorder.length) return null;
HashMap<Integer,Integer> map= new HashMap<>();
for(int i=0; i<inorder.length; i++){
    map.put(inorder[i],i);
}
     return  inToPost(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }
  TreeNode  inToPost(int[] in,int is,int ie, int[] pos,int ps,int pe,HashMap<Integer,Integer> map){
if(ie<is || ps>pe  ) return null;


TreeNode root=new TreeNode(pos[pe]);
int instart= map.get(root.val);
int numsleft= instart-is;

root.left=inToPost(in,is,instart-1,pos,ps,ps+numsleft-1,map);
root.right=inToPost(in,instart+1,ie,pos,ps+numsleft,pe-1,map);
return root;


    }
}