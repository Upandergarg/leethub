class Solution {

    int[] dp;

    public int climbStairs(int n, int[] costs) {

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(0, n, costs);
    }

    public int solve(int i, int n, int[] costs) {

        if (i == n) return 0;

        if (dp[i] != -1) return dp[i];

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;

        if (i + 1 <= n)
            a = costs[i] + 1 + solve(i + 1, n, costs);

        if (i + 2 <= n)
            b = costs[i + 1] + 4 + solve(i + 2, n, costs);

        if (i + 3 <= n)
            c = costs[i + 2] + 9 + solve(i + 3, n, costs);

        return dp[i] = Math.min(a, Math.min(b, c));
    }
}