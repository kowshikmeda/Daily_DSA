class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int total = 0;
        for (int i=0; i<apple.length; i++) {
            total += apple[i];
        }
        int count = 0;
        for (int i=capacity.length-1; i>=0; i--) {
            if (capacity[i] >= total) {
                count++;
                break;
            }
            total -= capacity[i];
            count++;
        }
        return count;
    }
}