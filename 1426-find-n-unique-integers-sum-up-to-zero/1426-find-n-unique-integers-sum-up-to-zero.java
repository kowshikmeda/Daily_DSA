class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;
        
        // If n is odd, include 0
        if (n % 2 == 1) {
            result[index++] = 0;
        }
        
        // Fill pairs (-i, i)
        for (int i = 1; index < n; i++) {
            result[index++] = i;
            result[index++] = -i;
        }
        
        return result;
    }
}