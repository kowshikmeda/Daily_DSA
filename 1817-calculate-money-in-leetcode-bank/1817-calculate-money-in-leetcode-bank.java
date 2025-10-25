class Solution {
    public int totalMoney(int n) {
        int total =0;
        int monday = 1;
        int dayamount = monday;
        for(int i=1;i<= n; i++){
            total += dayamount;
            dayamount++;
            if(i % 7 == 0){
                monday++;
                dayamount = monday;
            }
        }
        return total;
        
    }
}