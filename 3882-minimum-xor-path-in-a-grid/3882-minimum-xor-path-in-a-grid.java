import java.util.Arrays;

class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][][] dp = new int[n + 1][m + 1][1024];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dp[i][j], (int)1e9);
            }
        }
        
        for (int cur = 0; cur < 1024; cur++) {
            dp[n - 1][m - 1][cur] = cur ^ grid[n - 1][m - 1];
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) continue;
                
                for (int cur = 0; cur < 1024; cur++) {
                    int nextXor = cur ^ grid[i][j];
                    
                    int r = dp[i][j + 1][nextXor];
                    int d = dp[i + 1][j][nextXor];
                    
                    dp[i][j][cur] = Math.min(r, d);
                }
            }
        }
        
        return dp[0][0][0];
    }
}
