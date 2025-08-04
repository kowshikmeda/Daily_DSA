class Solution {
    public int totalFruit(int[] fruits) {
       int l=0,r=0,max=0,k=2;
        HashMap<Integer,Integer> hm=new HashMap();
        while(r<fruits.length){
            hm.put(fruits[r],hm.getOrDefault(fruits[r],0)+1);
            if(hm.size()>k){
                hm.put(fruits[l],hm.get(fruits[l])-1);
                if(hm.get(fruits[l])==0){
                    hm.remove(fruits[l]);
                }
                l++;
            }
            if(hm.size()<=k){
                max=Math.max(max,r-l+1);
            }
            r++;
        }
        return max;  
    }
}