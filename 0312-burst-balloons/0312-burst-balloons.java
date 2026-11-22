// class Solution {
//     int f(int i, int j, int[] nums) {
//     if (i > j)
//         return 0;

//     int max = Integer.MIN_VALUE;

//     for (int k = i; k <= j; k++) {
//         int coins = nums[i - 1] * nums[k] * nums[j + 1]
//                   + f(i, k - 1, nums)
//                   + f(k + 1, j, nums);

//         max = Math.max(max, coins);
//     }

//     return max;
// }
//     public int maxCoins(int[] nums) {
//     int m = nums.length;

//     int t[] = new int[m + 2];
//     t[0] = 1;
//     t[m + 1] = 1;

//     for (int i = 0; i < m; i++) {
//         t[i + 1] = nums[i];
//     }

//     return f(1, m, t);
// }
// }


class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int t[] = new int[n + 2];
        t[0] = 1;
        t[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            t[i + 1] = nums[i];
        }

        int dp[][] = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {

                if (i > j)
                    continue;

                int max = Integer.MIN_VALUE;

                for (int k = i; k <= j; k++) {
                    int coins = t[i - 1] * t[k] * t[j + 1]
                              + dp[i][k - 1]
                              + dp[k + 1][j];

                    max = Math.max(max, coins);
                }

                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }
}
