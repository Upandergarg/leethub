class Solution {

    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        int[][] rank = new int[26][n];

        //making rank matrix
        for (String s : votes) {
            for (int j = 0; j < s.length(); j++) {
                rank[s.charAt(j) - 'A'][j]++;
            }
        }
        Character[] teams = new Character[n];
        for (int i = 0; i < n; i++) {
            teams[i] = votes[0].charAt(i);
        }

        Arrays.sort(teams, (a, b) -> {
            int x = a - 'A';
            int y = b - 'A';
            for (int pos = 0; pos < n; pos++) {
                if (rank[x][pos] != rank[y][pos]) {
                    return rank[y][pos] - rank[x][pos];
                }
            }
            return a - b;
        });

        StringBuilder ans = new StringBuilder();
        for (char c : teams) {
            ans.append(c);
        }
        return ans.toString();
    }
}