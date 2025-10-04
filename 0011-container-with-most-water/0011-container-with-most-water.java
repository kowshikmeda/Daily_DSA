class Solution {
    public int maxArea(int[] height) {
      int j = height.length-1;
      int max =0;
      int i=0;
      while(i<j){

            int area = (j-i)*(min(height[i],height[j]));
            if(area > max){
                max= area;
            }
             if(height[i]<height[j]){
            i++;
        }
        else{
            j--;
         } 
      } 
      return max; 
    }
    public static int  min(int a, int b){
        if(a<b){
            return a;
        }
        else{
            return b;
        }
      }

}