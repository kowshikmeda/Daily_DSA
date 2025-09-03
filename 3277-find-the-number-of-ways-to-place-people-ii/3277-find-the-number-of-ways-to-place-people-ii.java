class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]); // y descending
            }
            return Integer.compare(a[0], b[0]); // x ascending
        });
        
        int res = 0;
        
        for (int i = 0; i < n - 1; i++) {
            int top = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (top < points[j][1] && points[j][1] <= points[i][1]) {
                    res++;
                    top = points[j][1];
                }
            }
        }
        
        return res;
    }
}