class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)m*k>(long)n)return -1;
        int low=Integer.MAX_VALUE,high=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            low=Math.min(low,bloomDay[i]);
            high=Math.max(high,bloomDay[i]);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isAcheived(bloomDay,mid,k,m)==true){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public boolean isAcheived(int []flowers,int day,int k,int m){
        int cnt=0;
        int boq=0;
        for(int i=0;i<flowers.length;i++){
            if(flowers[i]<=day){
                cnt++;
            }else{
                boq+=(cnt/k);
                cnt=0;

            }
        }
        boq+=(cnt/k);
        if(boq>=m)return true;
        return false;

    }
}