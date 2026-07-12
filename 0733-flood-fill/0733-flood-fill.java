import java.util.*;

class Solution {

    class Pair {
        int r;
        int c;
        int oc;

        Pair(int r, int c, int oc) {
            this.r = r;
            this.c = c;
            this.oc = oc;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;

        
        if (image[sr][sc] == color)
            return image;

        boolean[][] vis = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();

        int originalColor = image[sr][sc];
        q.add(new Pair(sr, sc, originalColor));

        vis[sr][sc] = true;
        image[sr][sc] = color;

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, -1, 0, 1};

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int r = curr.r;
            int c = curr.c;
            int oc = curr.oc;

            for (int i = 0; i < 4; i++) {

                int nr = r + row[i];
                int nc = c + col[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    !vis[nr][nc] &&
                    image[nr][nc] == oc) {

                    vis[nr][nc] = true;
                    image[nr][nc] = color;
                    q.add(new Pair(nr, nc, oc));
                }
            }
        }

        return image;
    }
}