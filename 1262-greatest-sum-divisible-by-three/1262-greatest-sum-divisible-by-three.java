class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        // dp[i][j] is max sum for first i numbers, remainder is j
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0);
        }
        dp[0][nums[0] % 3] = nums[0];
        for (int i = 1; i < n; i++) {
            // not use nums[i]
            for (int j = 0; j < 3; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            // use nums[i]
            for (int j = 0; j < 3; j++) {
                int remainder = (dp[i - 1][j] + nums[i]) % 3;
                dp[i][remainder] = Math.max(dp[i][remainder], dp[i - 1][j] + nums[i]);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i][0]);
        }
        return ans;
    }
}