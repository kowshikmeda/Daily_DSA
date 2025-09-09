class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] recent = new long[forget]; // Circular buffer for last 'forget' days
        recent[0] = 1;
        long activeSharers = 0;
        final long MOD = (long) 1e9 + 7;
        
        for (int day = 2; day <= n; day++) {
            int idx = (day - 1) % forget;
            // Remove forgetting people from activeSharers
            activeSharers = (activeSharers - recent[idx] + MOD) % MOD;
            // Add newly eligible people (day-delay)
            if (day - delay > 0) {
                int eligibleIdx = (day - delay - 1) % forget;
                activeSharers = (activeSharers + recent[eligibleIdx]) % MOD;
            }
            recent[idx] = activeSharers;
        }
        
        long total = 0;
        for (long count : recent) {
            total = (total + count) % MOD;
        }
        return (int) total;
    }
}