//Center approach

//move in opp dirrect
//for even -> go for i,i+1
//for odd -> go for i,i

class Solution {
    public String longestPalindrome(String s) {
        int start = 0, maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            // Odd length
            int l = i, r = i;

            while (l >= 0 && r < s.length() &&
                   s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            if (r - l - 1 > maxLen) {
                maxLen = r - l - 1;
                start = l + 1;
            }

            // Even length
            l = i;
            r = i + 1;

            while (l >= 0 && r < s.length() &&
                   s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            if (r - l - 1 > maxLen) {
                maxLen = r - l - 1;
                start = l + 1;
            }
        }

        return s.substring(start, start + maxLen);
    }
}