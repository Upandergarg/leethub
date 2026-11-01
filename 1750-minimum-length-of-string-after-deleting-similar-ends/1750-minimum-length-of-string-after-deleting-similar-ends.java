class Solution {
    public int minimumLength(String s) {
        int e = s.length() - 1;
        int l = 0;

        while (l < e) {
            if (s.charAt(l) != s.charAt(e)) {
                break;
            }

            char ch = s.charAt(l);

            while (l <= e && s.charAt(l) == ch) {
                l++;
            }

            while (l <= e && s.charAt(e) == ch) {
                e--;
            }
        }

        return e - l + 1;
    }
}