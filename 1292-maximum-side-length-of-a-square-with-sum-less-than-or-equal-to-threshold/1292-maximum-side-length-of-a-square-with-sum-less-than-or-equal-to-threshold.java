class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        int[][] pre = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                          + pre[i - 1][j]
                          + pre[i][j - 1]
                          - pre[i - 1][j - 1];
            }
        }

        int low = 0, high = Math.min(m, n), ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (existsSquare(pre, mid, threshold)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean existsSquare(int[][] pre, int len, int threshold) {
        if (len == 0) return true;

        for (int i = len; i < pre.length; i++) {
            for (int j = len; j < pre[0].length; j++) {
                int sum = pre[i][j]
                        - pre[i - len][j]
                        - pre[i][j - len]
                        + pre[i - len][j - len];
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}