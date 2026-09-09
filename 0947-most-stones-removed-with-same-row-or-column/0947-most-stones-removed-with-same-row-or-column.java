class Solution {
    void dfs(int i, int[] v, int[][] stones) {
        if (v[i]==1)
            return;
        v[i] = 1;

        for (int j = 0; j < stones.length; j++) {

            // if another stone has same row or 
            // column as this stone then both lie 
            // in the same component
            if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                dfs(j, v, stones);
            }
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;

        int vis[] = new int[n];
        int com = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, stones);
                com++;
            }

        }
        return n - com;
    }
}

//using dfs it can be done, 
// ans would be n-no of connectedComponents