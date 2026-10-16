class Solution {
    public String firstPalindrome(String[] words) {
        for (String s : words) {
            int left = 0;
            int right = s.length() - 1;
            boolean isPalindrome = true;

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    isPalindrome = false;
                    break;
                }

                left++;
                right--;
            }

            if (isPalindrome) {
                return s;
            }
        }

        return "";
    }
}