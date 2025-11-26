class Solution {
    int MOD = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        long[][][] dp = new long[m][n][k];
        dp[0][0][grid[0][0]%k] = 1;
        for (int i = 1; i < m; i++) {
            int val = grid[i][0];
            for (int mod = 0; mod < k; mod++) {
                int new_mod = (val + mod) % k;
                dp[i][0][new_mod] += dp[i-1][0][mod];
            }
        }
        for (int i = 1; i < n; i++) {
            int val = grid[0][i];
            for (int mod = 0; mod < k; mod++) {
                int new_mod = (val + mod) % k;
                dp[0][i][new_mod] = dp[0][i-1][mod];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int val = grid[i][j];
                for (int mod = 0; mod < k; mod++) {
                    int new_mod = (val + mod) % k;
                    dp[i][j][new_mod] = (dp[i-1][j][mod] + dp[i][j-1][mod]) % MOD;
                }
            }
        }
        return (int)dp[m-1][n-1][0];
    }
}