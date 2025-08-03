class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;

        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + fruits[i][1];
        }

        int maxFruits = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            while (left <= right) {
                int p_l = fruits[left][0];
                int p_r = fruits[right][0];
                
                int cost;

                if (p_r <= startPos) {
                    cost = startPos - p_l;
                } else if (p_l >= startPos) {
                    cost = p_r - startPos;
                } else {
                    int distToLeft = startPos - p_l;
                    int distToRight = p_r - startPos;
                    
                    int cost1 = 2 * distToLeft + distToRight;
                    int cost2 = distToLeft + 2 * distToRight;
                    cost = (cost1 < cost2) ? cost1 : cost2;
                }

                if (cost <= k) {
                    int currentFruits = prefixSum[right + 1] - prefixSum[left];
                    maxFruits = (currentFruits > maxFruits) ? currentFruits : maxFruits;
                    break; 
                } else {
                    left++;
                }
            }
        }
        return maxFruits;
    }
}