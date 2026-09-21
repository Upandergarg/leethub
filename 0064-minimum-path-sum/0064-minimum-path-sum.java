class Solution {
    int help(int i,int j,int[][] grid,int [][]dp){
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return (int)1e8;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=grid[i][j]+ help(i-1,j,grid,dp);
        int left= grid[i][j]+ help(i,j-1,grid,dp);
        return dp[i][j]=Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        int [][]dp= new int[n][m];
       
        // return help(n-1,m-1,grid,dp);
        dp[0][0]=grid[0][0];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                 if (i == 0 && j == 0)
                continue;
                int up = Integer.MAX_VALUE;
            int left = Integer.MAX_VALUE;

            if (i > 0)
                up = dp[i - 1][j];

            if (j > 0)
                left = dp[i][j - 1];
                dp[i][j]= grid[i][j] + Math.min(up,left);
            }
        }
        return dp[n-1][m-1];
    }
}