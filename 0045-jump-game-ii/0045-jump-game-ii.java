class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int l = 0;
        int r = 0;
        int j = 0;
        while (r < nums.length - 1) {
            int far = l;

            j++;
            for (int i = l; i <= r; i++) {

                far = Math.max(far, nums[i] + i);
            }
            l = r + 1;
            r = far;
        }
        return j;
    }
}