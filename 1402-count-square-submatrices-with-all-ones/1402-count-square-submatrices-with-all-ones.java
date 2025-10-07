class Solution {
    public int countSquares(int[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        
        // Initialize first row - each cell is its own square
        for(int i = 0; i < m; i++){
            ans += matrix[0][i];  // Count 1x1 squares
            dp[0][i] = matrix[0][i];
        }
        
        // Initialize first column - each cell is its own square  
        for(int i = 1; i < n; i++){  // Start from 1 to avoid double-counting (0,0)
            ans += matrix[i][0];     // Count 1x1 squares
            dp[i][0] = matrix[i][0];
        }
        
        // Fill DP table for remaining cells
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == 0) continue;  // No squares can end at 0
                
                // Key DP transition
                dp[i][j] = Math.min(dp[i - 1][j], 
                                   Math.min(dp[i - 1][j - 1], 
                                           dp[i][j - 1])) + 1;
                
                ans += dp[i][j];  // Add count of squares ending at (i,j)
            }
        }
        return ans;
    }
}