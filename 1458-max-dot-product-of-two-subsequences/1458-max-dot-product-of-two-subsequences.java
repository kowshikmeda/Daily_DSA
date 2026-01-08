class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length; 
        long[][] dp = new long[n1 + 1][n2 + 1];
        Arrays.fill(dp[0], Integer.MIN_VALUE);

        for(long[] arr: dp) {
            arr[0] = Integer.MIN_VALUE;
        }
        for(int i = 1; i <= n1; i++) {
            for(int  j = 1; j <= n2; j++) {
                int prod = nums1[i-1] * nums2[j-1];
                dp[i][j] =Math.max( Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i-1][j-1] + prod)), prod);
            }
        }

        return(int)dp[n1][n2];
    }
}