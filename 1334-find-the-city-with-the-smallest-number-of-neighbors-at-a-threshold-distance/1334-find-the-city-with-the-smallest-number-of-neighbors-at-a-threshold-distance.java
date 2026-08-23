class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j==i) dis[i][j]=0;
                else{
                dis[i][j] = (int) 1e9;
                }

            }
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            dis[u][v] = wt;
            dis[v][u] = wt;
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dis[i][k] != (int) 1e9 && dis[k][j] != (int) 1e9 && dis[i][j]> dis[i][k] + dis[k][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }
        int c = n;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++){
                if (dis[i][j] <= distanceThreshold)
                    cnt++;
            }
            if (c >= cnt) {
                ans = i;
                c = cnt;
            }
        }
        return ans;
    }
}