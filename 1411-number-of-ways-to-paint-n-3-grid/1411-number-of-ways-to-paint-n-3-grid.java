class Solution {
    public int numOfWays(int n) {
        final int MOD = 1000000007;
        
        // Base case: Row 1 has 6 two-color and 6 three-color patterns
        long twoColor = 6;
        long threeColor = 6;

        // Build up row by row
        for (int row = 2; row <= n; row++) {
            long newTwoColor = (twoColor * 3 + threeColor * 2) % MOD;
            long newThreeColor = (twoColor * 2 + threeColor * 2) % MOD;
            
            twoColor = newTwoColor;
            threeColor = newThreeColor;
        }

        return (int) ((twoColor + threeColor) % MOD);
    }
}