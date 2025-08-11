class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] mxl = new int[n]; 
        mxl[0] = height[0];
        for (int i = 1; i < n; i++) {
            mxl[i] = Math.max(height[i], mxl[i - 1]);
        }
        int[] mxr = new int[n]; 
        mxr[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            mxr[i] = Math.max(mxr[i + 1], height[i]);
        }      
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(mxr[i], mxl[i]) - height[i];
        }
        return ans;
    }
}