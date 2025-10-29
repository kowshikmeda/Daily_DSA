class Solution {
    public int smallestNumber(int n) {
        int c = 0;
        while (n > 0) {
            n >>= 1;
            c++;
        }
        return (1 << c) - 1;
    }
}