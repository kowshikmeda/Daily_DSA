class Solution {
    public int numSub(String s) {
        
        int mod = 1000000007;

        long countOfOne = 0;
        long ans = 0;

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '0'){
                ans = (ans + ((countOfOne * (countOfOne + 1)))/2) % mod;
                countOfOne = 0;
            }
            else{
                countOfOne++;
            }
        }
        ans = (ans + ((countOfOne * (countOfOne + 1)))/2) % mod;//if last character of the string is '1' we were not adding that no of substring int the above loop to our result so now adding it
        return (int)ans;

    }
}