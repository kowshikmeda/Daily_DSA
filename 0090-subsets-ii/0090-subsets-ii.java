import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        generateSubsets(nums, 0, currentSubset, result);
        return result;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(currentSubset));

        // Iterate through the remaining elements
        for (int i = index; i < nums.length; i++) {
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include the element and recurse
            currentSubset.add(nums[i]);
            generateSubsets(nums, i + 1, currentSubset, result);
            
            // Backtrack
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}