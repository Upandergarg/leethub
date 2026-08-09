class Solution {
    void dfs(int row,int col,int [] delrow, int [] delcol, int [][] vis, char[][] grid,int n, int m) {
        vis[row][col]=1;
        for(int i=0; i<4; i++){
            int nrow= delrow[i]+row;
            int ncol= delcol[i]+col;
            if( nrow>=0 && nrow<n && ncol>=0 && ncol<m &&   vis[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                dfs(nrow,ncol,delrow,delcol,vis,grid,n,m);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int [] delrow={-1,0,1,0};
        int [] delcol={0,1,0,-1};
        int [][] vis= new int[n][m];
        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    ans++;
                    dfs(i,j,delrow,delcol,vis,grid,n,m);
                }
            }
        }
        return ans;
    }
}