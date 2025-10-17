public class Solution {

    public int maxPartitionsAfterOperations(String s, int k) {
        int n = s.length();
        int[][] left = new int[n][3];   // [segments, mask, count] before i
        int[][] right = new int[n][3];  // [segments, mask, count] after i

        int seg = 0, mask = 0, cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            int bit = 1 << (s.charAt(i) - 'a');
            if ((mask & bit) == 0) {
                cnt++;
                if (cnt <= k) {
                    mask |= bit;
                } else {
                    seg++;
                    mask = bit;
                    cnt = 1;
                }
            }
            left[i + 1][0] = seg;
            left[i + 1][1] = mask;
            left[i + 1][2] = cnt;
        }

        seg = 0; mask = 0; cnt = 0;
        for (int i = n - 1; i > 0; i--) {
            int bit = 1 << (s.charAt(i) - 'a');
            if ((mask & bit) == 0) {
                cnt++;
                if (cnt <= k) {
                    mask |= bit;
                } else {
                    seg++;
                    mask = bit;
                    cnt = 1;
                }
            }
            right[i - 1][0] = seg;
            right[i - 1][1] = mask;
            right[i - 1][2] = cnt;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = left[i][0] + right[i][0] + 2;
            int unionMask = left[i][1] | right[i][1];
            int unionCnt = Integer.bitCount(unionMask);

            if (left[i][2] == k && right[i][2] == k && unionCnt < 26) {
                // both sides full; changing to a new char outside union forces an extra split
                cur++;
            } else if (Math.min(unionCnt + 1, 26) <= k) {
                // union plus changed char fits in k -> merge the two current segments
                cur--;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}