class Solution {
    int f(int i, int j, int[] cuts) {
        if (i > j)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int o = cuts[j + 1] - cuts[i - 1] + f(i, k - 1, cuts) + f(k + 1, j, cuts);
            min = Math.min(min, o);
        }
        return min;
    }

    public int minCost(int o, int[] cuts) {

          Arrays.sort(cuts);

        int m = cuts.length;
        int t[] = new int[m + 2];
        int dp[][] = new int[m + 2][m + 2];

        t[0] = 0;
        t[m + 1] = o;

        for (int i = 0; i < m; i++) {
            t[i + 1] = cuts[i];
        }

        for (int i = m; i >= 1; i--) {
            for (int j = 0; j <= m; j++) {

                if (i > j)
                    continue;

                int min = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {
                    int cost = t[j + 1] - t[i - 1]
                            + dp[i][k - 1]
                            + dp[k + 1][j];

                    min = Math.min(min, cost);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][m];
        
    }
}