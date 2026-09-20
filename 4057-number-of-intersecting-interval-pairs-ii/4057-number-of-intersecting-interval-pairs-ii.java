class Solution {
    public long countIntersectingIntervals(int[][] intervals) {

        int n = intervals.length;

        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        long intersecting = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {

            // Intervals whose end < current start
            while (j < n && ends[j] < starts[i]) {
                j++;
            }

            // j intervals are completely before current interval
            intersecting += i - j;
        }

        return intersecting;
    }
}