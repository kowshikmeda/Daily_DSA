class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> s = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }

        while (s.contains(original)) {
            original *= 2;
        }
        return original;
    }
}