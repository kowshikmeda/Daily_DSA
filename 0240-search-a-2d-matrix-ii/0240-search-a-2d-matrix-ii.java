class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int m=matrix.length-1;
      int n=matrix[0].length;
      int row=0,col=n-1;
      while(row<=m && col>=0){
        if(matrix[row][col]==target){
            return true;
        }
        if(matrix[row][col]<target){
            row++;
        }else{
            col--;
        }
      }  
      return false;
    }
}