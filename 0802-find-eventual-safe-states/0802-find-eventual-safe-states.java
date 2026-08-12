class Solution {
     boolean dfs(int node,List<List<Integer>> adj,int [] vis , int [] pathvis,int [] check){
        vis[node]= 1;
        pathvis[node]=1;
        check[node]=0;
        for(int it: adj.get(node)){
            if(vis[it]==0){
                if(dfs(it,adj,vis,pathvis,check)==true)return true; 
            }
            else if(pathvis[it]==1) return true;
        }
        pathvis[node]=0;
        check[node]=1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        	List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i<graph.length; i++) {
			adj.add(new ArrayList<>());
		}
		for (int i = 0; i<graph.length; i++) {
			for(int j=0; j<graph[i].length; j++){
                adj.get(i).add(graph[i][j]);
            }
			
		}
		
		int[] vis = new int[graph.length];
        int pathvis []= new int[graph.length];
        int check[]= new int[graph.length];
		
		
		for(int i=0; i<graph.length; i++){
                if(vis[i]==0){
                    dfs(i,adj,vis,pathvis,check);
                }
        
        }
        List<Integer> ans= new ArrayList<>();
        for(int i=0; i<check.length; i++){
            if(check[i]==1)  ans.add(i);
        }
		return ans;
		
    }
}