class Solution {
    public boolean canJump(int[] nums) {
         int n = nums.length;
        int maxReach = 0;

        for (int i = 0; i < n; i++) {
            // If the current index is unreachable, return false
            if (i > maxReach) {
                return false;
            }

            // Update the maximum reachable index
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // If we can reach or go beyond the last index, return true
            if (maxReach >= n - 1) {
                return true;
            }
        }
        
        return false;
    }
}