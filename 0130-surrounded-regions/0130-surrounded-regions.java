class Solution {
    void dfs(int row, int col,char [][] board, int [][] vis,int[] delrow,int [] delcol,int n,int m){
    vis[row][col]=1;

    for(int i=0; i<4; i++){
        int nrow= delrow[i]+row;
        int ncol= delcol[i]+col;
        if(ncol>=0 && ncol<m  && nrow>=0 && nrow<n && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
            dfs(nrow,ncol,board,vis,delrow,delcol,n,m);
        }
    }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int [][]vis= new int[n][m];
        int [] delrow= {-1,0,1,0};
        int [] delcol= {0,1,0,-1};
        //putting boundry 0s to dfs ,and marking them as visited
        for(int i=0; i<n; i++){
          if(vis[i][0]==0 && board[i][0]=='O') dfs(i,0,board,vis,delrow,delcol,n,m);
          if(vis[i][m-1]==0 && board[i][m-1]=='O') dfs(i,m-1,board,vis,delrow,delcol,n,m);
        }
        for(int i=0; i<m; i++){
          if(vis[0][i]==0 && board[0][i]=='O') dfs(0,i,board,vis,delrow,delcol,n,m);
          if(vis[n-1][i]==0 && board[n-1][i]=='O') dfs(n-1,i,board,vis,delrow,delcol,n,m);
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
              
                if(board[i][j]=='O' && vis[i][j]==0){
                     System.out.println("working");
                    board[i][j]='X';
                }
            }
        }

    }
}