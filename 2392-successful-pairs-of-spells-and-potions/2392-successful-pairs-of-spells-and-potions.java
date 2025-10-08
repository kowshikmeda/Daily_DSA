class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int[] ans = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int low = 0, high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if ((long) spells[i] * potions[mid] >= success)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            ans[i] = n - low;
        }

        return ans;
    }
}