
class Solution {
    public boolean isMatch(String s, String p) {
        return solve(s, p, s.length() - 1, p.length() - 1);
    }

    boolean solve(String s, String p, int i, int j) {

        if (i < 0 && j < 0) return true;

        if (j < 0) return false;

        if (i < 0) {
            if (p.charAt(j) == '*')
                return solve(s, p, i, j - 2);
            return false;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            return solve(s, p, i - 1, j - 1);
        }

        if (p.charAt(j) == '*') {

            boolean zero = solve(s, p, i, j - 2);

            boolean more = false;

            if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)) {
                more = solve(s, p, i - 1, j);
            }

            return zero || more;
        }

        return false;
    }
}
