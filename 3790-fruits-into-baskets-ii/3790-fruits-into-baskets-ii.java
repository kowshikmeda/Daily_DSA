class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplaced = 0;                  // To count how many are placed
        int n = fruits.length;

        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < fruits.length; j++) {
                // If basket can hold the fruit
                if (fruits[i] <= baskets[j]) {
                    unplaced += 1;        // Fruit placed
                    baskets[j] = -1;      // Mark basket as used
                    break;                // Move to next fruit
                }
            }
        }
        return n - unplaced;              // Total - placed = unplaced
    }
}