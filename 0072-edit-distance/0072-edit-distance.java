class Solution {
    public int minDistance(String a, String b) {
        int m = a.length(), n = b.length();

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int j = 0; j <= n; j++)
            prev[j] = j;

        for (int i = 1; i <= m; i++) {
            curr[0] = i;

            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(
                        curr[j - 1],       // Insert
                        Math.min(
                            prev[j],       // Delete
                            prev[j - 1]     // Replace
                        )
                    );
                }
            }

            prev = curr.clone();
        }

        return prev[n];
    }
}