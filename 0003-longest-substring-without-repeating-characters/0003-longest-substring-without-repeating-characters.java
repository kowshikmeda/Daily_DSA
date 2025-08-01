class Solution {
    public int lengthOfLongestSubstring(String s) {
        int []hs=new int[256];
        Arrays.fill(hs,-1);
        int l=0,r=0,maxlen=0;
        for(int i=0;i<s.length();i++){
            int curr=s.charAt(i);
            if(hs[curr]!=-1){
                if(hs[curr]>=l){
                    l=hs[curr]+1;
                }
            }
            int len=r-l+1;
            maxlen=Math.max(len,maxlen);
            hs[curr]=r;
            r++;

        }
        return maxlen;
    }
}