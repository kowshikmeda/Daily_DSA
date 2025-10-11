class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> map = new HashMap<>();

        // Step 1: Count frequencies
        for (int p : power) {
            map.put(p, map.getOrDefault(p, 0L) + 1);
        }

        // Step 2: Get keys and sort them
        List<Integer> nums = new ArrayList<>(map.keySet());
        Collections.sort(nums);

        int n = nums.size();
        Long[] dp = new Long[n];

        // Step 3: Use recursion + memoization
        return helper(map, nums, n - 1, dp);
    }

    private long helper(Map<Integer, Long> map, List<Integer> nums, int i, Long[] dp) {
        if (i < 0) return 0L;
        if (dp[i] != null) return dp[i];

        // Option 1: Skip current element
        long skip = helper(map, nums, i - 1, dp);

        // Option 2: Take current element
        long take = (long) nums.get(i) * map.get(nums.get(i));

        // Find previous element with difference > 2
        int j = i - 1;
        while (j >= 0 && nums.get(i) - nums.get(j) <= 2) j--;

        take += helper(map, nums, j, dp);

        dp[i] = Math.max(skip, take);
        return dp[i];
    }
}