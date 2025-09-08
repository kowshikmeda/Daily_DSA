class Solution {
    // Helper method to check if a number contains digit '0'
    private static boolean containsZero(int n) {
        while (n != 0) {
            if (n % 10 == 0) // if any digit is zero
                return true;
            n = n / 10; // move to next digit
        }
        return false;
    }

    public int[] getNoZeroIntegers(int n) {
        int a = 1, b = n - 1; // initial split

        // keep adjusting until both numbers contain no zero
        while (containsZero(a) || containsZero(b)) {
            a++;
            b--;
        }

        // return the valid pair
        return new int[] { a, b };
    }
}