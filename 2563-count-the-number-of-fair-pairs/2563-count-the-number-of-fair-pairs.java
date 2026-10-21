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


//find numebrs indexs of numebrs in that range


//first index where num is equla or greater than that lower
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

//first  number where it is greater than upper
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