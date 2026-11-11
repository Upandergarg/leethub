class Solution {

    int[][][] dp;

    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m][m];

        for (int[][] a : dp)
            for (int[] b : a)
                Arrays.fill(b, -1);

        return solve(0, 0, m - 1, grid);
    }

    public int solve(int i, int j1, int j2, int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // Out of bounds
        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m)
            return Integer.MIN_VALUE;

        // Base case
        if (i == n - 1) {
            if (j1 == j2)
                return grid[i][j1];

            return grid[i][j1] + grid[i][j2];
        }

        // Memoization check
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int cherries = grid[i][j1];

        if (j1 != j2)
            cherries += grid[i][j2];

        int maxi = Integer.MIN_VALUE;

        // 9 possible combinations
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {

                int ans = solve(i + 1, j1 + d1, j2 + d2, grid);

                maxi = Math.max(maxi, ans);
            }
        }

        // Store and return
        return dp[i][j1][j2] = cherries + maxi;
    }
}