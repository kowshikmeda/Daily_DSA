class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        ArrayList<Boolean> lst = new ArrayList<>();
        int n = 0;

        for (int i = 0; i < nums.length; i++) {
            n = n * 2 + nums[i];
            n = n % 5;
            lst.add(n == 0);
        }
        return lst;
    }
}