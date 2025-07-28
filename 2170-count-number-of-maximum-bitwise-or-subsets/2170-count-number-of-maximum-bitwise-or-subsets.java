/* backtrace */
/* Time: O(2^n) */
/* Space: O(n) */
class Solution {
    private int ans = 0;
    public int countMaxOrSubsets(int[] nums) {
        int maxval = 0;
        int n = nums.length;
        for(int num : nums)        
            maxval |= num;
        backtrace(nums, 0, 0, maxval);
        return ans;
    }
    private void backtrace(int[] nums, int num, int pos, int maxval){
        if(num == maxval){
            ans++;
        }
        for(int i = pos;i < nums.length;i++){
            backtrace(nums, num | nums[i], i + 1, maxval);
        }
    }
}