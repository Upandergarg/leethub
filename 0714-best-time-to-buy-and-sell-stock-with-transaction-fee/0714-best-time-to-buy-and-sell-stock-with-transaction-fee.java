class Solution {
    public int maxProfit(int[] prices, int fee) {
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
                   b2 = Math.max(-prices[i] + a1  , a2);
                else
                   b1 = Math.max(prices[i] + a2 -fee , a1);
            }
            a1=b1;
            a2=b2;
        }
        return b2;
    }
}