class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
           int left=dp[i-1];
           int before=0;
           if(i>1){
            before=dp[i-2]+nums[i];
           }else{
            before=nums[i];
           }
           dp[i]=Math.max(before,left);
        }
        return dp[n-1];
    }
}