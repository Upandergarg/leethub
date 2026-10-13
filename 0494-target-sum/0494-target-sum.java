class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int x : nums) sum += x;

        if (Math.abs(target) > sum) return 0;
        if ((sum + target) % 2 != 0) return 0;

        int t = (sum + target) / 2;
        int n = nums.length;

        int[][] dp = new int[n][t + 1];

        if (nums[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if (nums[0] != 0 && nums[0] <= t)
            dp[0][nums[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= t; j++) {
                int npick = dp[i - 1][j];
                int pick = 0;

                if (nums[i] <= j)
                    pick = dp[i - 1][j - nums[i]];

                dp[i][j] = pick + npick;
            }
        }

        return dp[n - 1][t];
    }
}