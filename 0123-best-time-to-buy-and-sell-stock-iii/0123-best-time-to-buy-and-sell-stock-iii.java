class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead = new int[5];
        int[] cur = new int[5];

        for (int i = n - 1; i >= 0; i--) {
            for (int b = 0; b < 4; b++) {
                if (b % 2 == 0)
                    cur[b] = Math.max(-prices[i] + ahead[b + 1], ahead[b]);
                else
                    cur[b] = Math.max(prices[i] + ahead[b + 1], ahead[b]);
            }
            ahead = cur.clone(); // Or swap references
        }
        return ahead[0];
    }
}
