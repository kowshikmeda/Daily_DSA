class Solution {
    public int myAtoi(String s) {
        
        s = s.trim();
        if (s == null || s.isEmpty()) return 0;
        int n = s.length();
        int i = 0, ans = 0, sign = 1;
        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        while(i < n && s.charAt(i) == '0') i++;
        return helper(s, i, ans, sign);
        
    }

    public int helper(String s, int i, long ans, int sign){
        if(i >= s.length() || !Character.isDigit(s.charAt(i))) return sign * (int) ans;
        ans = ans * 10 + (s.charAt(i) - '0');

        if(sign * ans >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(sign * ans <= Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return helper(s, i + 1, ans, sign);
    }
}