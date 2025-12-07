class Solution {
    public int countOdds(int low, int high) {
        int range=high-low+1;
        if(high%2==1 && low%2==1){
            return range/2+1;
        }
        return range/2;
    }
}