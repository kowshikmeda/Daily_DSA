import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            
            // Count frequency in current subarray
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // Sort by frequency desc, then value desc
            List<int[]> list = new ArrayList<>();
            for (int key : freq.keySet()) {
                list.add(new int[]{key, freq.get(key)});
            }

            list.sort((a, b) -> {
                if (b[1] == a[1]) return b[0] - a[0];
                return b[1] - a[1];
            });

            int sum = 0;
            int count = 0;

            // Pick top x frequent elements
            for (int[] p : list) {
                if (count == x) break;
                sum += p[0] * p[1];
                count++;
            }

            ans[i] = sum;
        }

        return ans;
    }
}