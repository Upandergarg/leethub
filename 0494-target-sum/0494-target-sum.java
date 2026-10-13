class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int x : nums) sum += x;

        if (Math.abs(target) > sum) return 0;
        if ((sum + target) % 2 != 0) return 0;

        int t = (sum + target) / 2;

        int[] dp = new int[t + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = t; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[t];
    }
}