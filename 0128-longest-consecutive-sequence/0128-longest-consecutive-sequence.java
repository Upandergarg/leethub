class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int ans = 0;
        for (int val : set) {
            if (!set.contains(val - 1)) {

                int current = val + 1;
                while (set.contains(current)) {
                    current++;
                }
                ans = Math.max(ans, current - val);
            }
        }
        return ans;
    }
}