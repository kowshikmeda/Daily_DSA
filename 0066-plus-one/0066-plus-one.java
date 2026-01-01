class Solution {
    public int[] plusOne(int[] nums) {
        int i = nums.length-1, carry = 1;
        List<Integer> temp = new ArrayList<>();
        while(i>=0){
            carry += nums[i--];
            temp.add(carry % 10);
            carry /= 10;
        }
        if(carry != 0)
            temp.add(carry);
        int j = temp.size();
        i = 0;
        int[] ans = new int[j];
        while(--j>=0){
            ans[i++] = temp.get(j);
        }
        return ans;
    }
}