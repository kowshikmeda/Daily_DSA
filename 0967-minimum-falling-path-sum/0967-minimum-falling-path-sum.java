class Solution {
    /**
     * Calculates the minimum sum of any falling path through the matrix.
     * The path must move directly down, diagonally left, or diagonally right.
     * * @param matrix The n x n array of integers.
     * @return The minimum falling path sum.
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        // Tabulation starts from the second row (i = 1)
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                // 1. Get the path from the direct top neighbor: (i-1, j)
                int pathFromUp = matrix[i - 1][j];
                
                // 2. Get the path from the diagonal left neighbor: (i-1, j-1)
                // If j=0, this path is out of bounds, so we set it to a very large value.
                int pathFromLeft = (j > 0) 
                                 ? matrix[i - 1][j - 1] 
                                 : Integer.MAX_VALUE;
                
                // 3. Get the path from the diagonal right neighbor: (i-1, j+1)
                // If j=n-1, this path is out of bounds, so we set it to a very large value.
                int pathFromRight = (j < n - 1) 
                                  ? matrix[i - 1][j + 1] 
                                  : Integer.MAX_VALUE;
                
                // The minimum path sum to the current cell (i, j) is the minimum of the 
                // three possible previous cells, plus the current cell's value.
                int minPrev = Math.min(pathFromUp, Math.min(pathFromLeft, pathFromRight));
                
                // Update the matrix cell in place to store the minimum path sum to this point.
                matrix[i][j] += minPrev;
            }
        }
        
        // After filling the DP table, the minimum falling path sum must be the 
        // minimum value in the last row (n-1).
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, matrix[n - 1][j]);
        }
        
        return minSum;
    }
}