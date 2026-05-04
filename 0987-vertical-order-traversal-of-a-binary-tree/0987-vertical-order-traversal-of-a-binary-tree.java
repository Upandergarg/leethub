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
    class pair{
        TreeNode Node;
        int row;
        int col;
       public pair(TreeNode Node, int row, int col){
            this.Node= Node;
            this.row= row;
            this.col= col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map= new TreeMap<>();
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null) return ans;
        Queue<pair> q= new LinkedList<pair>();
        q.add(new pair(root,0,0));
        while(!q.isEmpty()){
            pair p= q.poll();
            TreeNode t= p.Node;
            int x = p.row;
            int y = p.col;
            if(!map.containsKey(x)) map.put(x,new TreeMap<>());
            if(!map.get(x).containsKey(y)) map.get(x).put(y,new PriorityQueue<>());
            map.get(x).get(y).add(t.val);
            if(t.left!=null) q.offer(new pair(t.left,x-1,y+1));
            if(t.right!=null) q.offer(new pair(t.right,x+1,y+1));
        }

        for(TreeMap<Integer,PriorityQueue<Integer>> p: map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq: p.values()){
               while(!pq.isEmpty()){
                 ans.get(ans.size()-1).add(pq.poll());
               }
            }
        }
        return ans;
    }
}