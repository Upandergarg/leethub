
import java.util.*;

class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int[] bits = new int[set.size()];
        int idx = 0;

        for (int n : set) {
            bits[idx++] = Integer.bitCount(n);
        }

        Arrays.sort(bits);

        long count = 0;
        int m = bits.length;

        for (int i = 0; i < m; i++) {
            int target = k - bits[i];

            // Find the first count >= target
            int low = 0, high = m;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (bits[mid] >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            count += m - low;
        }

        return count;
    }
}
