class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
             List<List<Integer>> adj= new ArrayList<>();
         
         for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
           
        }
        int indeg[]= new int[numCourses];
        int c=0;
        for(int i=0; i<numCourses; i++){
            for(int j: adj.get(i)){
                indeg[j]++;
              
            }
          
        }
        
        // int vis[]= new int [V];
        int [] ans= new int[numCourses];
        Queue<Integer> q= new LinkedList<>();
        
        for(int i=0; i<indeg.length; i++){
            
            if(indeg[i]==0) q.offer(i);
           
        }
        
       
        
        //bfs
        while(!q.isEmpty()){
            int node= q.poll();
            
            ans[c++]=node;
            for(int it: adj.get(node)){
                
                indeg[it]--;
                if(indeg[it]==0  ){
                   q.offer(it);
                }
            }
        }
        
        
       if(c!=numCourses) return new int[0];
        return ans;
    }
}