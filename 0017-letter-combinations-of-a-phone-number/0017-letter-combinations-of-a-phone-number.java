import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    private final Map<Character, String> digitToLetters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder currentCombination, List<String> result) {
        // Base case: If the combination is complete
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);

        for (int i = 0; i < letters.length(); i++) {
            // Include the current letter
            currentCombination.append(letters.charAt(i));
            
            // Recurse to the next digit
            backtrack(digits, index + 1, currentCombination, result);

            // Backtrack by removing the last character
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}