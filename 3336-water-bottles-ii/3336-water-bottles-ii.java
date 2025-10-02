class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int fullBottles=0;
        int empty=numBottles;
        int BottleDrunk=numBottles;

        while(empty>=numExchange){
            while(empty!=0 && empty>=numExchange){
               empty=empty-numExchange;
               numExchange=numExchange+1;
               fullBottles+=1;
            }
            BottleDrunk+=fullBottles;
            empty=empty+fullBottles;
            fullBottles=0;
            
        }
        return BottleDrunk;
    }
}