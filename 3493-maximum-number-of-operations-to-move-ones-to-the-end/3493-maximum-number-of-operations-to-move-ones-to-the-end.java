class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int interval = 0, res = 0;
        for (int i = n-1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                res += interval;
            } else {
                interval++;
                // skip all zero interval
                while(i >= 0 && s.charAt(i) == '0') i--;
                i++;
            }
        }
        return res;
    }
}