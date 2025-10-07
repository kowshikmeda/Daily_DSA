class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        
        // No need to initialize with -1 or any other value for tabulation, 
        // as the loops will fill all cells starting from (0, 0).

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                // Base Case: Top-left cell (0, 0)
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue; // Move to the next iteration
                }

                // Initialize path sums to a very large value to represent infinity/impossibility
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;

                // Path from above (Only possible if i > 0)
                if (i > 0) {
                    // The path sum from above is the sum of the current cell's value
                    // and the minimum path sum to the cell above it.
                    up = grid[i][j] + dp[i - 1][j];
                }

                // Path from left (Only possible if j > 0)
                if (j > 0) {
                    // The path sum from the left is the sum of the current cell's value
                    // and the minimum path sum to the cell left of it.
                    left = grid[i][j] + dp[i][j - 1];
                }
                
                // The minimum path sum to (i, j) is the minimum of the two possible paths
                dp[i][j] = Math.min(up, left);
            }
        } 
        return dp[n - 1][m - 1];
    }
}