class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] rt = new int[26];
        for (char u : s.toCharArray()) {
            rt[u - 'a']++;
        }
        int[] lt = new int[26];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            int t = s.charAt(i) - 'a';
            rt[t]--;
            for (int j = 0; j < 26; j++) {
                if (lt[j] > 0 && rt[j] > 0) {
                    set.add(26 * t + j);
                }
            }
            lt[t]++;
        }

        return set.size(); 
    }
}