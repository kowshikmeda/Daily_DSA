class Solution {
    public long maxPower(int[] s, int r, int k) {
        long[] p = new long[s.length];
        for(int i=0; i<s.length; i++){
            int f=Math.max(i-r, 0);
            p[f]+=s[i];
            if(i+r+1<p.length)p[i+r+1]-=s[i];
        }

        long x=p[0], y=p[0], m=0;
        for(int i=0; i<p.length; i++){
            m+=p[i];
            if(x>m)x=m;
            if(y<m)y=m;
        }
        y+=k;
        long[] t = new long[p.length];
        while(x<y){
            m=(x+y+1)/2;
            if(possible(p, t, k, r, m))x=m;
            else y=m-1;
        }
        return y;
    }
    private boolean possible(long[] p, long[] t, int k, int r, long v){
        long c=0L;
        Arrays.fill(t, 0);

        for(int i=0; i<p.length; i++){
            c+=p[i]+t[i];
            if(c<v){
                if(v-c>k)return false;
                k-=(v-c);
                if(i+(2*r)+1<p.length)t[i+(2*r)+1]-=(v-c);
                c+=(v-c);
            }
        }
        return true;
    }
}