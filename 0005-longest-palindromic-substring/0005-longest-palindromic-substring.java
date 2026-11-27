class Solution {
    int maxLen = 0;

    boolean isPal(String s, int i, int j) {
        if (i >= j) return true;

        if (s.charAt(i) != s.charAt(j))
            return false;

        return isPal(s, i + 1, j - 1);
    }

    public String longestPalindrome(String s) {
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

                if (isPal(s, i, j) && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}