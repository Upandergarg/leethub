class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[5]; // Replaces int[n + 1][5]

        for (int i = n - 1; i >= 0; i--) {
            for (int b = 0; b < 4; b++) {
                if (b % 2 == 0)
                    dp[b] = Math.max(-prices[i] + dp[b + 1], dp[b]);
                else
                    dp[b] = Math.max(prices[i] + dp[b + 1], dp[b]);
            }
        }
        return dp[0];
    }
}
