class Solution {
    public long getDescentPeriods(int[] prices) {
        int n=prices.length;
        
        int prev=prices[0];
         if(n==1) return 1;
        long res=0;
        long cnt=1;

        long scnt=0;
        for(int i=1;i<n;i++){
          int cur=prices[i];

          if(prev-cur==1){
            cnt++;

          }
          else{
            scnt+=cnt;
            res=res+cnt*(cnt+1)/2;
           
            cnt=1;
           
          }

          prev=cur;
        }

        if(cnt!=1){
            scnt+=cnt;
            res+=cnt*(cnt+1)/2;
        }

        return (res+(n-scnt));
    }
}