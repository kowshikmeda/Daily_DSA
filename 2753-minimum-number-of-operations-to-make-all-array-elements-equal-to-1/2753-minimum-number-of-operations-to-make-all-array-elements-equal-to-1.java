class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;

        for (int num : nums)
            if (num == 1) ones++;

        if (ones > 0)
            return n - ones;

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    res = Math.min(res, (j - i) + (n - 1));
                    break;
                }
            }
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}