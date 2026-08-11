class Solution {
     void dfs(int row, int col,int [][] board, int [][] vis,int[] delrow,int [] delcol,int n,int m){
    vis[row][col]=1;

    for(int i=0; i<4; i++){
        int nrow= delrow[i]+row;
        int ncol= delcol[i]+col;
        if(ncol>=0 && ncol<m  && nrow>=0 && nrow<n && vis[nrow][ncol]==0 && board[nrow][ncol]==1){
            dfs(nrow,ncol,board,vis,delrow,delcol,n,m);
        }
    }
    }
    public int numEnclaves(int[][] grid) {
         int n=grid.length;
        int m=grid[0].length;
        int [][]vis= new int[n][m];
        int [] delrow= {-1,0,1,0};
        int [] delcol= {0,1,0,-1};
         //putting boundry 0s to dfs ,and marking them as visited
        for(int i=0; i<n; i++){
          if(vis[i][0]==0 && grid[i][0]==1) dfs(i,0,grid,vis,delrow,delcol,n,m);
          if(vis[i][m-1]==0 && grid[i][m-1]==1) dfs(i,m-1,grid,vis,delrow,delcol,n,m);
        }
        for(int i=0; i<m; i++){
          if(vis[0][i]==0 && grid[0][i]==1) dfs(0,i,grid,vis,delrow,delcol,n,m);
          if(vis[n-1][i]==0 && grid[n-1][i]==1) dfs(n-1,i,grid,vis,delrow,delcol,n,m);

        }
        int ans=0;
         for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
              
                if(grid[i][j]==1 && vis[i][j]==0){
                     System.out.println("working");
                  ans++;
                }
            }
        }
        return ans;
    }
}