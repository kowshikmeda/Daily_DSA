class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        int ans[] = new int[nums1.length];

        for(int i = nums2.length- 1; i >= 0; i--) {
            while(!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                hm.put(nums2[i], -1);
            }
            else {
                hm.put(nums2[i], s.peek());
            }
            s.push(nums2[i]);
        }
        
        for(int j = 0; j < nums1.length; j++) {
            ans[j] = hm.get(nums1[j]);
        }
        return ans;
    }
}