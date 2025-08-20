import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(num, target, 0, "", 0, 0, result);
        return result;
    }

    private void backtrack(String num, int target, int index, String currentPath, long currentEval, long prevNum, List<String> result) {
        // Base Case
        if (index == num.length()) {
            if (currentEval == target) {
                result.add(currentPath);
            }
            return;
        }

        // Recursive Step
        for (int i = index; i < num.length(); i++) {
            String currentStr = num.substring(index, i + 1);
            
            // Handle numbers with leading zeros (except for "0" itself)
            if (currentStr.length() > 1 && currentStr.charAt(0) == '0') {
                return; // This path is invalid, so stop
            }
            
            long currentNum = Long.parseLong(currentStr);

            if (index == 0) {
                // First number, no operator
                backtrack(num, target, i + 1, currentStr, currentNum, currentNum, result);
            } else {
                // Addition
                backtrack(num, target, i + 1, currentPath + "+" + currentStr, currentEval + currentNum, currentNum, result);

                // Subtraction
                backtrack(num, target, i + 1, currentPath + "-" + currentStr, currentEval - currentNum, -currentNum, result);

                // Multiplication (crucial for handling precedence)
                long newEval = currentEval - prevNum + (prevNum * currentNum);
                long newPrevNum = prevNum * currentNum;
                backtrack(num, target, i + 1, currentPath + "*" + currentStr, newEval, newPrevNum, result);
            }
        }
    }
}