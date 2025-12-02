class Solution {
    public int countTrapezoids(int[][] points) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int mod=1000000007;
        for(int i=0;i<points.length;i++){
            int y= points[i][1];
            map.put(y,map.getOrDefault(y,0)+1);
        }
        long sum=0;
        long sq=0;
        for(int key:map.keySet()){
            if(map.get(key)>=2){
            long pair= (long)map.get(key)*(map.get(key)-1)/2;
            sum+= pair;
            sq+= (pair*pair);
            }
        }
        return (int)((((sum*sum)- sq)/2)%mod);
        /*

        (a+b+c)^2 = a^2 + b^2 + c^2 + 2ab+ 2bc+ 2ca
        ab+bc+ca= (a+b+c)^2 /(a^2 + b^2 + c^2)
        we need this ab+bc+ca for counting trapezoids
        
        */
    }
}