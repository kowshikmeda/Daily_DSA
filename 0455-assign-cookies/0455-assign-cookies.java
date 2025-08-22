class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length,m=s.length;
        int l=0,r=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(r<n && l<m){
            if(s[l]>=g[r]){
                r=r+1;
            }
            l=l+1;
        }
        return r;
    }
}