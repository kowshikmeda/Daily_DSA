class Solution {
    public int characterReplacement(String s, int k) {
    int l=0,r=0,maxfreq=0,maxlen=0;
    int h[]= new int [26];
    while(r<s.length()){
        h[s.charAt(r)-'A']++;
        maxfreq=Math.max(maxfreq,h[s.charAt(r)-'A']);
        if((r-l+1)-maxfreq>k){
            h[s.charAt(l)-'A']--;
            maxfreq=0;
            l++;
        }
        if((r-l+1)-maxfreq<=k){
            maxlen=Math.max(maxlen,r-l+1);
        }
        r++;
    }
    return maxlen;

    }
}