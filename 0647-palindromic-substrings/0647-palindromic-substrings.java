class Solution {
    int count = 0;

    void expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() &&
               s.charAt(l) == s.charAt(r)) {

            count++;
            l--;
            r++;
        }
    }

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);       // Odd
            expand(s, i, i + 1);   // Even
        }

        return count;
    }
}