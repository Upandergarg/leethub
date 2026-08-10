class Solution {
   class tuple{
    int row;
    int col;
    int time;
    tuple(int row,int col, int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
   }
    public int orangesRotting(int[][] grid) {
        Queue<tuple> q= new LinkedList<>();
        int n= grid.length;
        int m=grid[0].length;
        int fresh=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    q.add(new tuple(i,j,0));
                }
                else if(grid[i][j]==1) fresh++;
            }
        }
        
        int cnt=0;
        int ans=0;
        int [] delrow= {-1,0,1,0};
        int [] delcol= {0,1,0,-1};
        while(!q.isEmpty()){
            tuple t= q.poll();
            int row=t.row;
            int col=t.col;
            int time=t.time;
          
            ans= Math.max(time,ans);
            for(int i=0; i<4; i++){
                int nrow= row+delrow[i];
                int ncol= col+delcol[i];
                
                if(nrow>=0 && nrow<n &&ncol>=0 && ncol<m && grid[nrow][ncol]==1){
                  
                    cnt++;
                    grid[nrow][ncol]=2;
                    q.add(new tuple(nrow,ncol,time+1));
                      System.out.println(q.peek().time);
                }
            }
            
        }
        if(cnt==fresh) return ans;
        else return -1;
    }
}