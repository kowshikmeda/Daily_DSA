class Solution {
    public int nextBeautifulNumber(int n) {
        int num=n+1;
        while(true)
        {
            if(fun(num)) return num;
            num++;
        }
        
    }
    public boolean fun(int num)
    {
        int[] freq=new int[10];
        while(num>0)
        {
            freq[num%10]++;
            num/=10;
        }
        if(freq[0]>0) return false;
        for(int i=1;i<=9;i++)
        {
            if(freq[i]>0 && freq[i]!=i) return false;
        }
        return true;
    }
}