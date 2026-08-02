class Solution {

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int pivot(int[] nums, int l, int r) {

        int p = nums[r];
        int i = l - 1;

        for (int j = l; j < r; j++) {

            if (nums[j] < p) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, r);

        return i + 1;
    }

    int qs(int[] nums, int k, int l, int r) {

        if (l == r)
            return nums[l];

        int p = pivot(nums, l, r);

        if (p == k)
            return nums[p];

        else if (p < k)
            return qs(nums, k, p + 1, r);

        else
            return qs(nums, k, l, p - 1);
    }

    public int findKthLargest(int[] nums, int k) {

        return qs(nums, nums.length - k, 0, nums.length - 1);
    }
}