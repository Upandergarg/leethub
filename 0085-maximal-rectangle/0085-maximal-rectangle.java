class Solution {
    int solve(int a[]) {
        Stack<Integer> s = new Stack<>();
        int ans = -1;
        for (int i = 0; i < a.length; i++) {
            while (!s.isEmpty() && a[s.peek()] > a[i]) {
                int cur = s.pop();
                int pse = s.isEmpty() ? -1 : s.peek();
                int nse = i;
                ans = Math.max(ans, a[cur] * (nse - pse - 1));
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            int nse = a.length;
            int ele = s.pop();
            int pse = s.isEmpty() ? -1 : s.peek();
            ans = Math.max(ans, a[ele] * (nse - pse - 1));
        }
        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        int prefixSum[][] = new int[n][m];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[j][i] == '0') {
                    sum = 0;
                } else {
                    sum += 1;
                }
                prefixSum[j][i] = sum;
            }
        }

        int ans = -1;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, solve(prefixSum[i]));
        }
        return ans;
    }
}

//put sum in 2d array and then for every row do last rectange ty[e thing  ] 
//whihc is i to get nse and pop to get pse
//and 