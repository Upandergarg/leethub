class Solution {
    class disjointSet {
        int par[];
        int size[];

        disjointSet(int v) {
            par = new int[v];
            size = new int[v];
            for (int i = 0; i < v; i++) {
                par[i] = i;
                size[i] = 1;
            }
        }

        int find(int n) {
            if (par[n] == n)
                return n;
            int ulp = find(par[n]);
            par[n] = ulp;
            return par[n];
        }

        void unionSize(int u, int v) {
            int ulp = find(u);
            int vlp = find(v);
            if (ulp == vlp)
                return;
            if (size[ulp] > size[vlp]) {
                par[vlp] = ulp;
                size[ulp] += size[vlp];
            } else if (size[vlp] > size[ulp]) {
                par[ulp] = vlp;

                size[vlp] += size[ulp];
            } else {
                par[vlp] = ulp;
                size[ulp] += size[vlp];
            }
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        disjointSet ds = new disjointSet(n * m);
        int[] dy = { -1, 0, 1, 0 };
        int[] dx = { 0, -1, 0, 1 };

        //maping all ones
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 0)
                    continue;
                for (int i = 0; i < 4; i++) {
                    int x2 = r + dx[i];
                    int y2 = c + dy[i];
                    int curn = r * m + c;
                    int adjn = x2 * m + y2;
                    if (x2 >= 0 && x2 < n && y2 >= 0 && y2 < m && grid[x2][y2] == 1) {
                        ds.unionSize(curn, adjn);
                    }
                }
            }
        }

        int max = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1)
                    continue;

                HashSet<Integer> com = new HashSet<>();
                for (int i = 0; i < 4; i++) {

                    int x2 = r + dx[i];
                    int y2 = c + dy[i];
                    int adjn = x2 * m + y2;
                    if (x2 >= 0 && x2 < n && y2 >= 0 && y2 < m && grid[x2][y2] == 1) {
                        com.add(ds.find(adjn));
                    }

                }
                int t = 0;
                for (int par : com) {
                    t += ds.size[par];
                }
                max = Math.max(max, t + 1);
            }
        }
        for(int allNo=0; allNo<n*m; allNo++){
            max=Math.max(max,ds.size[ds.find(allNo)]);
        }
        return max;

    }
}