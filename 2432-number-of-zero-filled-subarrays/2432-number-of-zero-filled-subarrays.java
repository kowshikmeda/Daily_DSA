class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int zeroCount = 0;
        for(int i:nums)
        {
            zeroCount = (i==0) ? zeroCount+1 : 0;
            res += zeroCount;
        }
        return res;  
    }
}