class Solution {
    void dfs(int node,  List<List<Integer>> adj,int [] vis){
        vis[node]=1;
        for(int it: adj.get(node)){
            if(vis[it]==0){
                dfs(it,adj,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj= new ArrayList<>();
  
        int n= isConnected.length;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        int m= isConnected[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int [] vis= new int[n];

        int ans=0;
        for(int i=0; i<adj.size(); i++){
            if(vis[i]==0){
                ans++;
                dfs(i,adj,vis);
            }
        }
        return ans;
    }
}