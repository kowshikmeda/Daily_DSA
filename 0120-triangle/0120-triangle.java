class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] DP = new int[n][n];

        // Base case: DP last row = triangle last row
        for(int i=0; i<n; i++){
            DP[n-1][i] = triangle.get(n-1).get(i);
        }

        // Top down approach in Tabulation
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                int currElement = triangle.get(i).get(j);

                int moveDown = currElement + DP[i+1][j];
                int moveDiagonal = currElement + DP[i+1][j+1];

                DP[i][j] = Math.min(moveDown, moveDiagonal);
            }
        }

        return DP[0][0];
    }
}