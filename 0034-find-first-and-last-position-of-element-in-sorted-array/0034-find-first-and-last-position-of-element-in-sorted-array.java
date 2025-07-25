class Solution {
    public int[] searchRange(int[] nums, int target) {
        int []ans={-1,-1};
        if(nums.length==0)return ans;
        findFirst(nums,ans,target);
        findLast(nums,ans,target);
        return ans;

    }
    public void findFirst(int []nums,int []ans,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                ans[0]=mid;
                right=mid-1;
            }else if(nums[mid]<target){
               left=mid+1;
                
            }else{
                right=mid-1;
            }
        }



    }

    public void findLast(int []nums,int []ans,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                ans[1]=mid;
                left=mid+1;
                
            }else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
    }


}