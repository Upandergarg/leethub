import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = lowerBound(nums, i + 1, lower - nums[i]);
            int right = upperBound(nums, i + 1, upper - nums[i]);

            count += right - left;
        }

        return count;
    }

    int lowerBound(int[] nums, int start, int target) {
        int low = start, high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    int upperBound(int[] nums, int start, int target) {
        int low = start, high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > target)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }
}