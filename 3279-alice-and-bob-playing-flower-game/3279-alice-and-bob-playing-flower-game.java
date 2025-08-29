class Solution {
    public long flowerGame(int n, int m) {
        long odd_n = n%2 == 0 ? n/2 : (n/2) + 1;
        long even_n = n/2;

        long odd_m = m%2 == 0 ? m/2 : (m/2) + 1;
        long even_m = m/2;

        return (odd_n * even_m) + (even_n * odd_m);
    }
}