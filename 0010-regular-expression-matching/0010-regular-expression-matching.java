
class Solution {
    int[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new int[s.length()+1][p.length()+1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(s, p, s.length() - 1, p.length() - 1);
    }

    boolean solve(String s, String p, int i, int j) {

        if (i < 0 && j < 0) return true;
        if (j < 0) return false;

        if (dp[i + 1][j + 1] != -1)
            return dp[i + 1][j + 1] == 1;

        boolean ans = false;

        if (i < 0) {
            if (p.charAt(j) == '*')
                ans = solve(s, p, i, j - 2);
        }
        else if (p.charAt(j) == '*') {
            boolean zero = solve(s, p, i, j - 2);

            boolean more = false;
            if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i))
                more = solve(s, p, i - 1, j);

            ans = zero || more;
        }
        else if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            ans = solve(s, p, i - 1, j - 1);
        }

        dp[i + 1][j + 1] = ans ? 1 : 0;
        return ans;
    }
}
