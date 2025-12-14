class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        char[] arr = corridor.toCharArray();

        // Count total seats
        int totalSeats = 0;
        for (char c : arr) {
            if (c == 'S') totalSeats++;
        }

        // If no seats or odd number of seats, no valid partition
        if (totalSeats == 0 || totalSeats % 2 != 0) return 0;

        long ways = 1;
        int seatsInCurrentGroup = 0;
        int plantsBetweenPairs = 0;

        for (char c : arr) {
            if (c == 'S') {
                seatsInCurrentGroup++;

                // When encountering the first seat of a new pair (i.e., 3rd seat overall in window)
                if (seatsInCurrentGroup == 3) {
                    ways = (ways * (plantsBetweenPairs + 1L)) % MOD;
                    plantsBetweenPairs = 0;
                    seatsInCurrentGroup = 1; // current 'S' becomes first seat of new pair
                }
            } else { // 'P'
                // Count plants only after completing a pair of seats
                if (seatsInCurrentGroup == 2) {
                    plantsBetweenPairs++;
                }
            }
        }

        return (int) ways;
    }
}