class Solution {
    public int findMin(int[] nums) {
      int left=0,right=nums.length-1,min=Integer.MAX_VALUE;
      while(left<=right){
        int mid=left+(right-left)/2;
        if(nums[left]<=nums[right]){
            min=Math.min(nums[left],min);
            break;
        }
        if(nums[left]<=nums[mid]){
            min=Math.min(nums[left],min);
            left=mid+1;
            
           
        }else{
           min=Math.min(nums[mid],min);
            right=mid-1;
        }

      } 
      return min; 
    }
}