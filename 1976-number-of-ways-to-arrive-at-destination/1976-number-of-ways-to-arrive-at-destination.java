class Solution {
    class pair {
        int n;
        long d;

        pair(int n, long d) {
            this.n = n;
            this.d = d;
        }
    }

    public int countPaths(int n, int[][] roads) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }

        long[] dis = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dis, Long.MAX_VALUE);

        int mod = 1_000_000_007;

        dis[0] = 0;
        ways[0] = 1;

        PriorityQueue<pair> q =
            new PriorityQueue<>((a, b) -> Long.compare(a.d, b.d));

        q.add(new pair(0, 0));

        while (!q.isEmpty()) {

            pair p = q.poll();

            int no = p.n;
            long d = p.d;

            if (d > dis[no])
                continue;

            for (int[] edge : adj.get(no)) {

                int next = edge[0];
                int wt = edge[1];

                long newDist = d + wt;

                if (dis[next] > newDist) {

                    dis[next] = newDist;
                    ways[next] = ways[no];

                    q.add(new pair(next, newDist));
                }

                else if (dis[next] == newDist) {

                    ways[next] =
                        (ways[next] + ways[no]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}