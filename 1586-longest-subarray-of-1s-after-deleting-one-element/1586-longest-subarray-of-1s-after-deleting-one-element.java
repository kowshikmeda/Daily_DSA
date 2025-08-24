class Solution {
    public int longestSubarray(int[] nums) {
        int i=0,j=0,lastzero_idx=-1,res=0,n=nums.length;
        while(j<n){
            if(nums[j]==0){
                i=lastzero_idx+1;
                lastzero_idx=j;
            }
            res=Math.max(res,j-i);
            j++;
        }
        return res; 
    }
}