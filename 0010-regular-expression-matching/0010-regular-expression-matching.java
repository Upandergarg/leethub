
class Solution {
    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int j = 2; j <= m; j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 2];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (p.charAt(j - 1) == '*') {

                    boolean zero = dp[i][j - 2];

                    boolean more = false;

                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        more = dp[i - 1][j];
                    }

                    dp[i][j] = zero || more;
                }
                else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[n][m];
    }
}
