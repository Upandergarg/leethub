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
        void parents(TreeNode root,HashMap<TreeNode,TreeNode> m){
Queue<TreeNode> q= new LinkedList<>();
q.add(root);
m.put(root,null);
while(!q.isEmpty()){
    TreeNode t= q.poll();
    if(t.left!=null){
        m.put(t.left,t);
        q.offer(t.left);
    }
    if(t.right!=null){
        m.put(t.right,t);
        q.offer(t.right);
    }

}
    }
    TreeNode find(int s,TreeNode root){
       
      if(root==null) return null;
      if(root.val==s) return root;
      TreeNode l= find(s,root.left);
      if(l!=null) return l;
     return  find(s,root.right);

    }
    public int amountOfTime(TreeNode root, int start) {
         HashMap<TreeNode,TreeNode> parTrack= new HashMap<>();
        parents(root,parTrack);
        HashMap<TreeNode,Integer> vis= new HashMap<>();
        Queue<TreeNode> q= new LinkedList<>();
        TreeNode target= find(start,root);
          vis.put(target,1);
        q.offer(target);
    int p=0;
        while(!q.isEmpty()){
            int s= q.size();

int fl=0;
           
            for(int i=0; i<s; i++){
                 TreeNode t= q.poll();
                if(t.left!=null && !vis.containsKey(t.left)){
q.offer(t.left);
vis.put(t.left,1);
fl=1;
                }
                if(t.right!=null &&!vis.containsKey(t.right)){
q.offer(t.right);
vis.put(t.right,1);
fl=1;
                }
                if( parTrack.get(t)!=null &&!vis.containsKey(parTrack.get(t))){
q.offer(parTrack.get(t));
vis.put(parTrack.get(t),1);
fl=1;
                }
                
            }
            if(fl==1) p++;
          
        }
       return p;


    }
}