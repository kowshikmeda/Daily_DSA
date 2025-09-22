class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0;
        for (int x : nums) {
            freq[x]++;
            if (freq[x] > max) max = freq[x];
        }
        int ans = 0;
        for (int f : freq) if (f == max) ans += f;
        return ans; 
    }
}