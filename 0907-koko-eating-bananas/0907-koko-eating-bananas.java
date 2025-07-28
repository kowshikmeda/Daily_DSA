class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      int low=1;
      int high=-1;
      for(int i=0;i<piles.length;i++){
        high=Math.max(high,piles[i]);
      }  
      while(low<=high){
        int mid=low+(high-low)/2;
        if(totalHours(mid,piles)<=h){
            high=mid-1;
        }else{
            low=mid+1;
        }
      }
      return low;
    }
    public int totalHours(int k,int []piles){
        int hours=0;
        for(int i=0;i<piles.length;i++){
            hours+=Math.ceil((double)piles[i]/(double)k);
        }
        return hours;
    }
}