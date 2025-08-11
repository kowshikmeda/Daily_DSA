class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int maxArea=0;
        int [][]prefixsum=new int[n][m];
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum=sum+(matrix[i][j]-'0');
                if(matrix[i][j]=='0')sum=0;
                prefixsum[i][j]=sum;
            }
        }
        for(int i=0;i<n;i++){
            maxArea=Math.max(maxArea,hist(prefixsum[i]));
        }
        return maxArea;
    }
    int hist(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!st.empty() && heights[st.peek()] > heights[i]) {
                int element = st.peek();
                st.pop();
                int nse = i;
                int pse = st.empty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
            }
            st.push(i);
        }
        while (!st.empty()) {
            int element = st.peek();
            st.pop();
            int nse = heights.length;
            int pse = st.empty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
        }
        return maxArea;
    
}
}