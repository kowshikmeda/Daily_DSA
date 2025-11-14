class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];

        for(int[] q : queries){
            int row1 = q[0], col1 = q[1], row2 = q[2] + 1, col2 = q[3] + 1;
            ans[row1][col1]++;
            if(row2 < n && col2 < n) ans[row2][col2]++;
            if(col2 < n) ans[row1][col2]--;
            if(row2 < n) ans[row2][col1]--;
        }

        for(int i = 0; i < n; i++){
            for(int j = 1; j < n; j++){
                ans[i][j] += ans[i][j - 1];
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                ans[i][j] += ans[i - 1][j];
            }
        }

        return ans;
    }
}