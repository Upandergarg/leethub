
class Solution {
    public boolean isPerfectSquare(int n) {
        if (n < 0) return false;

        long low = 0, high = n;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long square = mid * mid;

            if (square == n) return true;
            else if (square < n) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }
}
