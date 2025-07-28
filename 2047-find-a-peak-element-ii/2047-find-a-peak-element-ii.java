class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat[0].length,n=mat.length;
       int low=0,high=m-1;
       while(low<=high){
        int mid=low+(high-low)/2;
        int maxRowIdx=maxRow(mat,mid,m,n);
        int left=mid-1>=0?mat[maxRowIdx][mid-1]:-1;
        int right=mid+1<m?mat[maxRowIdx][mid+1]:-1;
        if(mat[maxRowIdx][mid]>left && mat[maxRowIdx][mid]>right){
            return new int[]{maxRowIdx,mid};
        }else if(mat[maxRowIdx][mid]<mat[maxRowIdx][mid+1]){
            low=mid+1;

        }else{
            high=mid-1;
        }
       } 
       return new int[]{-1,-1};
    }
    public int maxRow(int [][]mat,int mid,int col,int rows ){
        int idx=-1,max=-9999;
        for(int i=0;i<rows;i++){
            if(mat[i][mid]>max){
                idx=i;
                max=mat[i][mid];
            }
        }
        return idx;
    }
}