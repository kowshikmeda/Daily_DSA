class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        

        boolean check = true;
        for(int i=0;i<bits.length;i++){
            if(bits[i] == 1 && check)
            check = false;

            else if(!check){
                if(bits[i] == 1 || (bits[i] == 0 && i!=bits.length-1))
                check = true;
            }
        }

        return check ;

    }
}