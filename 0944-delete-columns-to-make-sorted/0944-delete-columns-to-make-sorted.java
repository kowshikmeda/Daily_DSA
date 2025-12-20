class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int k = strs[0].length();
        int count = 0;
        for (int i = 0; i < k; i++) {
            int prev = strs[0].charAt(i);
            int cur = strs[0].charAt(i);
            for (int j = 0; j < n; j++) {
                cur = strs[j].charAt(i);
                if (cur < prev) {
                    count++;
                    break;
                }
                prev = cur;
            }
        }
        return count;
    }
}