class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign = true; // true indicate our dividend and divisor are positive value 
        if(divisor < 0 && dividend >= 0) sign = false; // divsisor has -ve value 
        if(dividend < 0 && divisor > 0) sign = false; // dividend has -ve value 

        // handle base case 
        if(dividend == divisor) return 1;

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int qut = 0;

        while(dvd >= dvs){
            int cnt = 0;
            while(dvd >= (dvs << (cnt + 1))) {
                cnt++;
            }
            qut += 1 << cnt;
            dvd -= dvs << cnt;
        }
        if(qut == (1 << 31) && sign) return Integer.MAX_VALUE;
        if(qut == (1 << 31) && !sign) return Integer.MIN_VALUE;
        return sign ? qut : -qut;
    }
}