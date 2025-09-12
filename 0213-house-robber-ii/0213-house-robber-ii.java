class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        return Math.max(func(nums, 1, n), func(nums, 0, n-1));
    }

    private int func(int[] nums, int start, int n) {
        if(start == n - 1) {
            return nums[start];
        }
        int prev1 = nums[start];
        int prev = Math.max(nums[start + 1], nums[start]);

        for(int i = start + 2; i < n; i++) {
            int take = nums[i] + prev1;
            int notTake = prev;

            prev1 = prev;
            prev = Math.max(take, notTake);
        }

        return prev;
    }
}