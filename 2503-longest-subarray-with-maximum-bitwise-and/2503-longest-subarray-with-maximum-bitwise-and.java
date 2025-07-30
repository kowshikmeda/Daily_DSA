class Solution {
    public int longestSubarray(int[] nums) {
      int max=-1;
      for(int a : nums){
        if(a>max){
            max=a;
        }
      }
      int c=0,maxcount=0;
      for(int i=0;i<nums.length;i++){
        if(max==nums[i]){
            c++;
        }
        else{
            maxcount=Math.max(maxcount,c);
            c=0;
        }
      }
      maxcount=Math.max(maxcount,c);
      
        return maxcount;
    }
}