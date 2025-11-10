class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n + 1];
        int top = 0, ans = 0;

        for (int num : nums) {
            while (stack[top] > num) {
                top--;
                ans++;
            }
            if (stack[top] != num) {
                top++;
                stack[top] = num;
            }
        }
        return ans + top;
    }
}