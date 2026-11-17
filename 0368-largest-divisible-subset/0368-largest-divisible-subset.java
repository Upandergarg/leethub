
class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] h = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(h, -1);

        int max = 1;
        int li = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    h[i] = j;
                }
            }

            if (max < dp[i]) {
                max = dp[i];
                li = i;
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (li != -1) {
            ans.add(nums[li]);
            li = h[li];
        }

        return ans;
    }
}
