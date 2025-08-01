class Solution {
    public int longestOnes(int[] nums, int k) {
       int l=0,r=0,zeroCount=0,maxlen=0;
       for(int i=0;i<nums.length;i++){
        if(nums[i]==0)zeroCount++;
        if(zeroCount>k){
            if(nums[l]==0)zeroCount--;
            l++;
        }
        if(zeroCount<=k){
            int len=r-l+1;
            maxlen=Math.max(len,maxlen);
        }
        r++;

       }
       return maxlen; 
    }
}