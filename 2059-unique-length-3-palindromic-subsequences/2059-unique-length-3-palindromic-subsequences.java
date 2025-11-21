class Solution {
    public int countPalindromicSubsequence(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        // initialization with -1;
        for(int i=0;i<26;i++){
            first[i] = last[i] = -1;
        }

        // counting 1st and last occurance of each character

        for(int i=0;i<n;i++ ){

            int index = s.charAt(i) -'a';
            
            if( first[index] == -1){
                first[index] = i;
            }
            last[index] =i;
        }

        // counting distinct elements between 1st and last index of characters

        int ans =0;

        for(int i =0;i<26;i++){

            HashSet<Character>hs = new HashSet<>();

            for(int j = first[i]+1; j< last[i];j++){
                hs.add(s.charAt(j));
            }
            ans += hs.size();
        }
        return ans;
    }
}