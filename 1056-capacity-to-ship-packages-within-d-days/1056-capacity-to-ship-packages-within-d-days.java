class Solution {
    public int shipWithinDays(int[] weights, int days) {
      int low=-1,high=0;
      for(int i=0;i<weights.length;i++){
        low=Math.max(low,weights[i]);
        high=high+weights[i];
      }  
      while(low<=high){
        int mid=low+(high-low)/2;
        if(totalDays(weights,mid)<=days){
            high=mid-1;
        }else{
            low=mid+1;
        }
      }
      return low;
    }
    public int totalDays(int []weights,int capacity){
        int days=1,load=0;
        for(int i=0;i<weights.length;i++){
            if(load+weights[i]>capacity){
                days++;
                load=weights[i];
            }else{
                load=load+weights[i];
            }

        }
        return days;
    }
}