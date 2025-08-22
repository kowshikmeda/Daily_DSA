class Solution {
    public int jump(int[] nums) {
      int jumps = 0, end = 0, farthest = 0;
        
        // loop until second last index
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]); // update farthest reach
            if (i == end) { // reached current boundary
                jumps++;           // must jump
                end = farthest;    // extend boundary
            }
        }
        
        return jumps;   
    }
}