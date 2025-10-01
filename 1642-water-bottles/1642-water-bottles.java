class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count=numBottles;
        int rem=numBottles;
        while(rem>=numExchange){
            int extra=rem/numExchange;
            count+=extra;
            rem=rem%numExchange+extra;
            
        }
        return count;
    }
}