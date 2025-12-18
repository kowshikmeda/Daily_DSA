
//Sliding window solution
// We will calculate total profit with original strategies and then will maintain 2 sliding window, first is of size k and second is of size k/2, so at every position we will check for totalProfit - k profit + k/2 profit and maximize it
class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        long totalOriginalProfit = 0;
        for (int i = 0; i < n; i++) {
            totalOriginalProfit += (long) prices[i] * strategy[i];
        }

        long maxTotalProfit = totalOriginalProfit;
        long currentWindowOriginalProfit = 0;
        long currentSubWindowBoostProfit = 0;

        // Sliding window approach
        for (int i = 0; i < n; i++) {
            // Add current element to our windows
            currentWindowOriginalProfit += (long) prices[i] * strategy[i];
            currentSubWindowBoostProfit += (long) prices[i];

            // Maintain the sub-window (k/2)
            if (i >= k / 2) {
                currentSubWindowBoostProfit -= (long) prices[i - (k / 2)];
            }

            // Maintain the main window (k)
            if (i >= k) {
                currentWindowOriginalProfit -= (long) prices[i - k] * strategy[i - k];
            }

            // At each step i, if we have reached at least size k,
            // we evaluate the potential "swap"
            if (i >= k - 1) {
                // Formula: Original Total - Original Window + Specialized Sub-window
                long currentPotential = totalOriginalProfit - currentWindowOriginalProfit + currentSubWindowBoostProfit;
                maxTotalProfit = Math.max(maxTotalProfit, currentPotential);
            }
        }

        return maxTotalProfit;
    }
}