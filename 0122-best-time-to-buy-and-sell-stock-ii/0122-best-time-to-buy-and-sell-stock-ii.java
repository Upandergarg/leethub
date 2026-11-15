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
        // int[][] dp = new int[prices.length+1][2];
        int a1=0;
        int a2=0;
        int b1;
        int b2;
      
        // return f(0,1,prices,dp);

     b1=0;
     b2=0;
        for (int i = n-1; i >=0; i--) {
            for (int b = 0; b <= 1; b++) {
                if (b == 1)
                   b2 = Math.max(-prices[i] + a1 , a2);
                else
                   b1 = Math.max(prices[i] + a2 , a1);
            }
            a1=b1;
            a2=b2;
        }
        return a2;
    }
}