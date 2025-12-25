class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n=happiness.length,val=0;
        long hv=0;

        for(int i=0;i<k;i++)
        {
            val=happiness[n-1-i]-i;
            if(val>0)   hv+=val;
        }
        return hv;
    }
}