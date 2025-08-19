import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, n, "", result);
        return result;
    }

    private void generate(int open, int close, String currentString, List<String> result) {
        // Base case: If no more parentheses can be added, a valid string is formed
        if (open == 0 && close == 0) {
            result.add(currentString);
            return;
        }

        // Recursive step 1: Add an open parenthesis if available
        if (open > 0) {
            generate(open - 1, close, currentString + "(", result);
        }

        // Recursive step 2: Add a closed parenthesis only if it won't violate the balance
        // This means the number of open parentheses must be greater than closed
        if (close > open) {
            generate(open, close - 1, currentString + ")", result);
        }
    }
}