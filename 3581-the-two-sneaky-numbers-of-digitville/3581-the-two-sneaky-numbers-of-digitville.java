class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int a = -1, b = -1;

        for (int num : nums) {
            if (!set.add(num)) {
                if (a == -1) {
                    a = num;     
                } else {
                    b = num;     
                    break;       
                }
            }
        }

        return new int[]{a, b};
    }
}