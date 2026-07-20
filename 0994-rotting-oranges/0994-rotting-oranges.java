class Solution {
    class pair{
        int row;
        int col;
        int t;
        pair(int row,int col, int t){
            this.row=row;
            this.col=col;
            this.t=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int N=grid.length;
        int M=grid[0].length;
        int [][] vis= new int[N][M];
        int [] nrow= {-1,0,1,0};
        int [] ncol= {0,-1,0,1}; 
        int fresh=0;
        Queue<pair> q= new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(grid[i][j]==2){
                    vis[i][j]=1;
                    q.add(new pair(i,j,0));
                }
                if(grid[i][j]==1) fresh++;
                vis[i][j]=0;
            }
        }
        int time=0;
        int cnt=0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int ti=q.peek().t;
            time= Math.max(ti,time);
            q.poll();
            for(int i=0; i<4; i++){
                int ro = r + nrow[i];
                int co = c + ncol[i];
                if(ro>=0 && ro<N && co>=0 && co <M && vis[ro][co]==0 && grid[ro][co]==1){
                    q.add( new pair(ro,co,ti+1));
                    vis[ro][co]=1;
                    cnt++;
                }
           
            }

        }
        if(cnt!=fresh) return -1;
        else return time;
    }
}