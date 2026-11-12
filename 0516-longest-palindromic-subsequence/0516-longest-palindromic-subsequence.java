class Solution {
    int f(int i, int j, String s, String s1, int[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == s1.charAt(j))
            return dp[i][j] = 1 + f(i - 1, j - 1, s, s1, dp);

        return dp[i][j] = Math.max(
            f(i - 1, j, s, s1, dp),
            f(i, j - 1, s, s1, dp)
        );
    }

    public int longestPalindromeSubseq(String s) {
        String s1 = new StringBuilder(s).reverse().toString();

        int n = s.length();
        int[][] dp = new int[n][n];

        for (int[] row : dp)
            java.util.Arrays.fill(row, -1);

        return f(n - 1, n - 1, s, s1, dp);
    }
}