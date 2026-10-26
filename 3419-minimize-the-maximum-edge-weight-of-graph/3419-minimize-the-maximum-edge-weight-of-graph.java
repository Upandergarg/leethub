
import java.util.*;

class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        if (n == 1) return 0;

        List<List<int[]>> rev = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rev.add(new ArrayList<>());
        }

        int maxWeight = 0;

        for (int[] e : edges) {
            int from = e[0];
            int to = e[1];
            int weight = e[2];

            // Reverse the edge
            rev.get(to).add(new int[]{from, weight});

            maxWeight = Math.max(maxWeight, weight);
        }

        int low = 1, high = maxWeight;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReachAll(n, rev, mid)) {
                ans = mid;
                high = mid - 1;  // Try a smaller maximum weight
            } else {
                low = mid + 1;   // Need heavier edges
            }
        }

        return ans;
    }

    private boolean canReachAll(
        int n, List<List<int[]>> rev, int limit
    ) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int[] edge : rev.get(node)) {
                int neighbor = edge[0];
                int weight = edge[1];

                if (weight <= limit && !visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    count++;
                }
            }
        }

        return count == n;
    }
}
