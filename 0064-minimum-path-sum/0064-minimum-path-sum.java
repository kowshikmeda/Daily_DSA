class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // dp stores the results for the previous row
        int[] dp = new int[m];
        
        for (int i = 0; i < n; i++) {
            int[] current = new int[m]; // Stores results for the current row
            for (int j = 0; j < m; j++) {
                
                // Base Case (0, 0)
                if (i == 0 && j == 0) {
                    current[j] = grid[i][j];
                    continue;
                }

                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;

                // Path from above (using dp array which holds the previous row's results)
                if (i > 0) {
                    up = grid[i][j] + dp[j];
                }
                
                // Path from left (using current array which holds the current row's results so far)
                if (j > 0) {
                    left = grid[i][j] + current[j - 1];
                }
                
                current[j] = Math.min(up, left);
            }
            dp = current; // Update dp to be the current row for the next iteration
        }
        
        // The final answer is the last element of the last calculated row
        return dp[m - 1];
    }
}