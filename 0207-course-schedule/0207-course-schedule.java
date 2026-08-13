class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         List<List<Integer>> adj= new ArrayList<>();
         
         for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
           
        }
        int indeg[]= new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int j: adj.get(i)){
                indeg[j]++;
              
            }
          
        }
        
        // int vis[]= new int [V];
        ArrayList<Integer> ans= new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        
        for(int i=0; i<indeg.length; i++){
            
            if(indeg[i]==0) q.offer(i);
           
        }
        
       
        
        //bfs
        while(!q.isEmpty()){
            int node= q.poll();
            
            ans.add(node);
            for(int it: adj.get(node)){
                
                indeg[it]--;
                if(indeg[it]==0  ){
                   q.offer(it);
                }
            }
        }
        
        
        System.out.print(ans);
       
        return ans.size()==numCourses;
    }
}