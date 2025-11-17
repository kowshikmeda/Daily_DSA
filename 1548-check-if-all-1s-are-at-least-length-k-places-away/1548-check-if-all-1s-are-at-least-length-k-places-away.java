class Solution {
    public boolean kLengthApart(int[] nums, int k)
    {
        int n = nums.length;
        int left =0,right = 0;
        int zeroes = 0;
        boolean valid = true;
        while(right<n)
        {
            if(right>0 && nums[right]==1)
            {
                if(zeroes<k) valid =  false;
                else valid = true;
                zeroes = 0;
                left = right;
                right++;
            }
            else
            {
                if(nums[right]==0) zeroes++;
                right++;
            }
        }
        return valid;
    }
}