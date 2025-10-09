class Solution {
    public long minTime(int[] skill, int[] mana) {
        int m = mana.length;
        int n = skill.length;
        long total = 0, start = 0;
        long[] presum = new long[n+1];
        for (int i = 1; i < m + 1 ; i++){
            for (int j = 1; j < n + 1; j++){
                int time = mana[i-1] * skill[j-1];
                
                if(j == 1){
                    total = start;
                    start = 0;
                }
                total += time;
                if (i < m){
                    presum[j] = presum[j-1] + (mana[i] * skill[j-1]);
                    start = Math.max(start, total - presum[j - 1]);
                }
            }
        }
        return total;
    }
}