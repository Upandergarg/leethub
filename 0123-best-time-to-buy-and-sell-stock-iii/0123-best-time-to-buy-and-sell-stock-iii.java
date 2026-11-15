class Solution {
    public int maxProfit(int[] prices) {
           int n = prices.length;
        int[][] dp = new int[prices.length+1][5];
        
        // return f(0,1,prices,dp);

      
        for (int i = n-1; i >=0; i--) {
            for (int b = 0; b <4; b++) {
                if (b%2 == 0)
                    dp[i][b] = Math.max(-prices[i] + dp[i + 1][ b+1] , dp[i + 1][ b]);
                else
                    dp[i][b] = Math.max(prices[i] + dp[i + 1] [b+1] , dp[i + 1] [b] );
            }
        }
        return dp[0][0];
    }
}