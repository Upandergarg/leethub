//hint-> think as 2 persons starting togetther from startng position.
class Solution {

    int help(int r1, int r2, int c1, int[][] grid, int n,int dp[][][]) {
        int c2 = r1 - r2 + c1;
        if (r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return -(int) 1e9;

        //checking for meme
        if(dp[r1][r2][c1]!=-1) return dp[r1][r2][c1];
        //for both reaching last cell
        if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];

        //for both reaching same cell
        int ch = 0;
        if (r1 == r2 && c1 == c2) {
            ch += grid[r1][c1];
        } else {
            ch += grid[r1][c1] + grid[r2][c2];
        }

        //covring paths

        //both down
        int br = help(r1, r2, c1 + 1, grid, n,dp);
        //both right
        int bd = help(r1 + 1, r2 + 1, c1, grid, n,dp);

        //1 right,2down
        int r = help(r1, r2 + 1, c1 + 1, grid, n,dp);
        //2right, 1down
        int d = help(r1 + 1, r2, c1, grid, n,dp);

        return dp[r1][r2][c1]= ch + Math.max(Math.max(br, bd), Math.max(r, d));
    }

    public int cherryPickup(int[][] grid) {
        
        int n = grid.length;
        int dp[][][]=new int[n+1][n+1][n+1];

        for (int[][] layer : dp) {
    for (int[] row : layer) {
        Arrays.fill(row, -1);
    }
}
        int one = help(0, 0, 0, grid, n,dp);

        return Math.max(0,one);
    }
}