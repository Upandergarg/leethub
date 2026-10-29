class Solution {
    int help(int i, int j, int cur, int[][] grid, int n, int m,int [][][]dp) {
      
        if (i >= n || j >= m) return (int)1e9;
    
        int nextXor = cur ^ grid[i][j];

   
        if (i == n - 1 && j == m - 1) return nextXor;
if(dp[i][j][cur]!=-1) return dp[i][j][cur];
        
        int r = help(i, j + 1, nextXor, grid, n, m,dp);
        int d = help(i + 1, j, nextXor, grid, n, m,dp);

   
        return dp[i][j][cur]= Math.min(r, d);
    }

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
      
        int [][][]dp = new int[n][m][1024];
        
       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return help(0, 0, 0, grid, grid.length, grid[0].length,dp);
    }
}
