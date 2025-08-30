class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int row=0; row<9; row++){
            for(int col=0; col<9; col++){
                char num = board[row][col];
                if(num == '.')   continue;
                for(int i=0; i<9; i++){
                    if(board[row][i]==num && i!=col)   return false;
                    if(board[i][col]==num && i!=row)   return false;
                }
            }
        }

        for(int row=0; row<9; row+=3){
            for(int col=0; col<9; col+=3){
                HashSet<Character> nums = new HashSet<>();
                for(int i=0; i<3; i++){
                    for(int j=0; j<3; j++){
                        if(board[row+i][col+j] == '.')  continue;
                        if(nums.contains(board[row+i][col+j]))  return false;
                        else    nums.add(board[row+i][col+j]);
                    }
                }
            }
        }
        return true;
    }
}