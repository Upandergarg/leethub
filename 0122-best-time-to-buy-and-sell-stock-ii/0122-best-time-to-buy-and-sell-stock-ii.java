class Solution {
    int f(int i, int b, int[] p, int[][] dp) {
        if (i == p.length)
            return 0;
        if (dp[i][b] != -1)
            return dp[i][b];
        if (b == 1)
            return dp[i][b] = Math.max(-p[i] + f(i + 1, 0, p, dp), f(i + 1, 1, p, dp));
        return dp[i][b] = Math.max(p[i] + f(i + 1, 1, p, dp), f(i + 1, 0, p, dp));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[prices.length+1][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // return f(0,1,prices,dp);

        dp[n][0] = 0;

        dp[n][1] = 0;
        for (int i = n-1; i >=0; i--) {
            for (int b = 0; b <= 1; b++) {
                if (b == 1)
                    dp[i][b] = Math.max(-prices[i] + dp[i + 1][ 0] , dp[i + 1][ 1]);
                else
                    dp[i][b] = Math.max(prices[i] + dp[i + 1] [1] , dp[i + 1] [0] );
            }
        }
        return dp[0][1];
    }
}