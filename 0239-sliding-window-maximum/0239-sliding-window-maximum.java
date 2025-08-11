class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];
        int ansIndex = 0;

        for(int i=0;i<nums.length;i++){
            //maintain monotnic decreasing order 
            while(!deq.isEmpty() && nums[deq.getLast()]<nums[i]){
                deq.removeLast();
            }

            deq.addLast(i);

            //removing out of window elements from start
            while(!deq.isEmpty() && deq.getFirst()<=i-k){
                deq.removeFirst();
            }

            if(i>=k-1){
                ans[ansIndex++] = nums[deq.getFirst()];
            }
        }
        return ans;
    }
}