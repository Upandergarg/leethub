class Solution {
    int[][] dp;

    boolean isPal(String s, int i, int j) {
        if (i >= j) return true;

        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        if (s.charAt(i) != s.charAt(j))
            return (dp[i][j] = 0) == 1;

        return (dp[i][j] = isPal(s, i + 1, j - 1) ? 1 : 0) == 1;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        int maxLen = 0, start = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPal(s, i, j) && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}