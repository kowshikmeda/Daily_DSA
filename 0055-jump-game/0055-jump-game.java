class Solution {
    public boolean canJump(int[] nums) {
         int ans = nums.length - 1; // target position
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= ans) {
                ans = i; // we can reach target from i
            }
        }
        return ans == 0;
    }
}