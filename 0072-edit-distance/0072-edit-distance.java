import java.util.Arrays;

class Solution {
    int help(int i, int j, String a, String b, int[][] dp) {

        if (i == 0) return j;
        if (j == 0) return i;

        if (dp[i][j] != -1) return dp[i][j];

        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            return dp[i][j] = help(i - 1, j - 1, a, b, dp);
        }

        int insert = help(i, j - 1, a, b, dp);
        int delete = help(i - 1, j, a, b, dp);
        int replace = help(i - 1, j - 1, a, b, dp);

        return dp[i][j] = 1 + Math.min(insert,
                              Math.min(delete, replace));
    }

    public int minDistance(String a, String b) {
        int m = a.length(), n = b.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return help(m, n, a, b, dp);
    }
}