import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Use a set for O(1) average time complexity for lookups
        Set<String> dict = new HashSet<>(wordDict);
        // memo[i] will be true if substring s.substring(i) can be segmented
        Boolean[] memo = new Boolean[s.length()];
        return canBreak(s, dict, 0, memo);
    }

    private boolean canBreak(String s, Set<String> dict, int start, Boolean[] memo) {
        // Base Case: Reached the end of the string, so a valid segmentation was found
        if (start == s.length()) {
            return true;
        }

        // Check if the result for this subproblem is already in the memo table
        if (memo[start] != null) {
            return memo[start];
        }

        // Recursive Step: Try all possible prefixes
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (dict.contains(prefix) && canBreak(s, dict, end, memo)) {
                memo[start] = true;
                return true;
            }
        }

        // If no valid segmentation was found from this starting point
        memo[start] = false;
        return false;
    }
}