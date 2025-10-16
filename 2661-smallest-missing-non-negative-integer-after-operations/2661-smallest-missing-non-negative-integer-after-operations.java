class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int freq[] = new int[value];
        for(int num : nums) {
            int mod = num%value;
            if(mod<0)
                mod+=value;
            freq[mod]++;
        }
        int minFreq = Integer.MAX_VALUE;
        int minNumber = -1;
        for(int i=0;i<value;i++) {
            if(freq[i] < minFreq) {
                minFreq = freq[i];
                minNumber = i;
            }
        }
        return minNumber + value*minFreq;
    }
}