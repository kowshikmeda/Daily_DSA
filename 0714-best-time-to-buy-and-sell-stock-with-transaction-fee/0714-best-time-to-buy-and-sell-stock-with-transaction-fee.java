class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2]; // extra row for base case

        for(int ind = n - 1; ind >= 0; ind--){
            for(int buy = 0; buy < 2; buy++){
                int profit = 0;
                if(buy == 1){
                    int take = -prices[ind] + dp[ind + 1][0];
                    int noTake = dp[ind + 1][1];
                    profit = Math.max(take, noTake);
                } else {
                    int sell = prices[ind] - fee + dp[ind + 1][1];
                    int noSell = dp[ind + 1][0];
                    profit = Math.max(sell, noSell);
                }
                dp[ind][buy] = profit;
            }
        }

        return dp[0][1];
    }
}