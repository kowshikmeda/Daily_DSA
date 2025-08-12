class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;

        long N = n; // use long to handle overflow
        boolean sign = N >= 0;
        N = Math.abs(N);

        double ans = 1.0;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x;
                N--;
            } else {
                x *= x;
                N /= 2;
            }
        }
        return sign ? ans : 1.0 / ans;
    }
}
