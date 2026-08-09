class Solution {
    void dfs(int sr,int sc,int[][] image,int[][] ans,int inicolor,int color,int[] delrow, int[] delcol,int n,int m){
        ans[sr][sc]=color;

        for(int i=0; i<4; i++){
            int nrow= sr+delrow[i];
            int ncol= sc+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ans[nrow][ncol]==inicolor && ans[nrow][ncol]!=color ){
                dfs(nrow,ncol,image,ans,inicolor,color,delrow,delcol,n,m);
            }
        
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int [][] ans= image;
        int n=image.length;
        int m= image[0].length;
          int [] delrow={-1,0,1,0};
        int [] delcol={0,1,0,-1};
       
        int inicolor=image[sr][sc];

        dfs(sr,sc,image,ans,inicolor,color,delrow,delcol,n,m);
        return ans;
    }
}