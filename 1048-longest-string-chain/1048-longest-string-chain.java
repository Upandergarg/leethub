
class Solution {

    boolean comp(String i, String j) {

        if (i.length() != j.length() + 1)
            return false;

        int f = 0, s = 0;

        while (f < i.length()) {
            if (s < j.length() && i.charAt(f) == j.charAt(s)) {
                f++;
                s++;
            } else {
                f++;
            }
        }

        return s == j.length();
    }

    public int longestStrChain(String[] words) {

        int n = words.length;

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (comp(words[i], words[j]) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
