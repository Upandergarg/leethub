import java.util.Arrays;

class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        
        // We pad by 1 (size n+1) so that looking at index [r+1] or [c+1] 
        // near the edges safely hits our out-of-bounds boundary without throwing an exception.
        int[][][] dp = new int[n + 1][n + 1][n + 1];
        
        // Step 1: Initialize the table with -1e9 (our out-of-bounds/invalid path marker)
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -(int)1e9);
            }
        }
        
        // Step 2: Loop OPPOSITE of recursion (From End to Start)
        for (int r1 = n - 1; r1 >= 0; r1--) {
            for (int r2 = n - 1; r2 >= 0; r2--) {
                for (int c1 = n - 1; c1 >= 0; c1--) {
                    
                    // Fixed your formula: c2 = r1 + c1 - r2
                    int c2 = r1 + c1 - r2; 
                    
                    // Boundary check for the derived column
                    if (c2 < 0 || c2 >= n) {
                        continue;
                    }
                    
                    // Obstacle check: if either hits a wall, it stays unreachable
                    if (grid[r1][c1] == -1 || grid[r2][c2] == -1) {
                        continue;
                    }
                    
                    // Base case: Both reached the absolute end destination
                    if (r1 == n - 1 && c1 == n - 1) {
                        dp[r1][r2][c1] = grid[r1][c1];
                        continue;
                    }
                    
                    // Calculate cherries picked at current cells
                    int ch = 0;
                    if (r1 == r2 && c1 == c2) {
                        ch += grid[r1][c1];
                    } else {
                        ch += grid[r1][c1] + grid[r2][c2];
                    }
                    
                    // Look FORWARD into the table (exactly like your recursive steps)
                    int br = dp[r1][r2][c1 + 1];     // both right
                    int bd = dp[r1 + 1][r2 + 1][c1]; // both down
                    int r  = dp[r1][r2 + 1][c1 + 1]; // 1 right, 2 down
                    int d  = dp[r1 + 1][r2][c1];     // 2 right, 1 down
                    
                    // Store the result
                    dp[r1][r2][c1] = ch + Math.max(Math.max(br, bd), Math.max(r, d));
                }
            }
        }
        
        // Step 3: The final answer is now waiting at the starting position
        return Math.max(0, dp[0][0][0]);
    }
}
