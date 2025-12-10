class Solution {
    static int mod=1000000007;
    public long fact(long n){
        long res=1;
        for(int i=1;i<=n;i++){
            res=(res*i)%mod;
        }
        return res;
    }
    public int countPermutations(int[] arr) {
        
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(arr[i]<=arr[0])return 0;
        }
        return (int)fact(n-1);
    }
}