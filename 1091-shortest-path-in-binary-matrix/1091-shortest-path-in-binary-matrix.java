
class Solution {
    class tuple {
        int w;
        int r;
        int c;

        tuple(int w, int r, int c) {
            this.w = w;
            this.r = r;
            this.c = c;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }

        if (n == 1 && m == 1) {
            return 1;
        }

        Queue<tuple> q = new LinkedList<>();

        int[][] dis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dis[i][j] = (int) 1e9;
            }
        }

        dis[0][0] = 0;
        q.add(new tuple(1, 0, 0));

       int[] delrow = {-1, -1, -1, 0, 0, 1, 1, 1};
       int[] delcol = {-1,  0,  1, -1, 1, -1, 0, 1};

        while (!q.isEmpty()) {
            tuple t = q.poll();

            int w = t.w;
            int r = t.r;
            int c = t.c;

            for (int i = 0; i < 8; i++) {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    grid[nrow][ncol] == 0 &&
                    w + 1 < dis[nrow][ncol]) {

                    dis[nrow][ncol] = w + 1;

                    if (nrow == n - 1 && ncol == m - 1) {
                        return w + 1;
                    }

                    q.add(new tuple(w + 1, nrow, ncol));
                }
            }
        }

        return -1;
    }
}