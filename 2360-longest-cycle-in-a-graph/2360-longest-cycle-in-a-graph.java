//using 3 satate dfs
class Solution {
    public int longestCycle(int[] edges) {

        int n = edges.length;
        int[] state = new int[n];

        int maxLength = -1;

        for (int i = 0; i < n; i++) {

            if (state[i] != 0) continue;

            int node = i;

            // Traverse current path
            while (node != -1 && state[node] == 0) {
                state[node] = 1;
                node = edges[node];
            }

            // Cycle detected
            if (node != -1 && state[node] == 1) {

                int length = 0;
                int curr = node;

                do {
                    length++;
                    curr = edges[curr];
                } while (curr != node);

                maxLength = Math.max(maxLength, length);
            }

            // Mark current path as processed
            node = i;

            while (node != -1 && state[node] == 1) {
                state[node] = 2;
                node = edges[node];
            }
        }

        return maxLength;
    }
}
