class Solution {
    class tuple {
        int dif;
        int r;
        int c;

        tuple(int dif, int r, int c) {
            this.dif = dif;
            this.r = r;
            this.c = c;
        }
    }

    public int minimumEffortPath(int[][] heights) {
     PriorityQueue<tuple> q =
    new PriorityQueue<>((a, b) -> a.dif - b.dif);

        int n = heights.length;
        int m = heights[0].length;


        int[][] dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dis[i][j] = (int) 1e9;
            }
        }
        dis[0][0] = 0;

        q.add(new tuple(0, 0, 0));
        int[] delrow = { -1, 0, 1, 0 };
        int[] delcol = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            tuple t = q.poll();
            int dif = t.dif;
            int r = t.r;
            int c = t.c;
            if (r == n - 1 && c == m - 1)
                return dif;
            for (int i = 0; i < 4; i++) {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    int ef = Math.max(dif, Math.abs(heights[r][c] - heights[nrow][ncol]));
                    if (ef < dis[nrow][ncol]) {
                        dis[nrow][ncol] = ef;
                        q.add(new tuple(ef, nrow, ncol));
                    }

                }
            }
        }
        return 0;
    }
}