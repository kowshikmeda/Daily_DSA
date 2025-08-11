class Solution {
    public long subArrayRanges(int[] nums) {
        return sumMax(nums)-sumMin(nums);
    }
    long sumMin(int[] arr) {
       int nse[] =findNse(arr);
       int pse[]=findPse(arr);
       long total=0;
       for(int i=0;i<arr.length;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            total=total+(right*left*1L*arr[i]);
       } 
       return total;
    }
    int[] findNse(int []arr){
        int n=arr.length;
        int nse[]=new int[n];
        Stack<Integer> st=new Stack();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);

        }
        return nse;
    }

    int[] findPse(int []arr){
        int pse[]=new int[arr.length];
        Stack<Integer> st=new Stack();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);

        }
        return pse;
    }
    long sumMax(int[] arr) {
       int nge[] =findNge(arr);
       int pge[]=findPge(arr);
       long total=0;
       for(int i=0;i<arr.length;i++){
            int left=i-pge[i];
            int right=nge[i]-i;
            total=total+(right*left*1L*arr[i]);
       } 
       return total;
    }
    int[] findNge(int []arr){
        int n=arr.length;
        int nge[]=new int[n];
        Stack<Integer> st=new Stack();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            nge[i]=st.isEmpty()?n:st.peek();
            st.push(i);

        }
        return nge;
    }

    int[] findPge(int []arr){
        int pge[]=new int[arr.length];
        Stack<Integer> st=new Stack();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            pge[i]=st.isEmpty()?-1:st.peek();
            st.push(i);

        }
        return pge;
    }
}