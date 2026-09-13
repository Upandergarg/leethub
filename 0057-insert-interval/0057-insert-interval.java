class Solution {
    public int[][] insert(int[][] in, int[] ni) {

        int n = in.length;
        int i = 0;
        int idx = 0;

        int[][] ans = new int[n + 1][2];

        // 1. Intervals completely before ni
        while (i < n && in[i][1] < ni[0]) {
            ans[idx++] = in[i++];
        }

        // 2. Merge overlapping intervals
        while (i < n && in[i][0] <= ni[1]) {
            ni[0] = Math.min(in[i][0], ni[0]);
            ni[1] = Math.max(in[i][1], ni[1]);
            i++;
        }

        // Add merged interval
        ans[idx++] = ni;

        // 3. Remaining intervals
        while (i < n) {
            ans[idx++] = in[i++];
        }

        // Remove unused rows
        return Arrays.copyOf(ans, idx);
    }
}