class Solution {
    public int maximum69Number (int num) {
        int maxVal = num;
        String s = String.valueOf(num);

        int i = 0;
        while(i < s.length()) {
            StringBuilder sb = new StringBuilder(s);
            char c = s.charAt(i);

            if(c == '6') {
                sb.setCharAt(i, '9');
            }

            int n = Integer.parseInt(sb.toString());
            if(n > maxVal) {
                maxVal = n;
            }

            i++;
        }

        return maxVal;
    }
}