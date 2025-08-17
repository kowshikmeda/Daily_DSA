class Solution {
    public boolean isNStraightHand(int[] nums, int k) {
        if((nums.length%k)!=0) 
            return false;

        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                int nf = hm.get(nums[i])+1;
                hm.put(nums[i],nf);
            }
            else{
                hm.put(nums[i],1);
            }
        }
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a,b)->a.get(0)-b.get(0));
        for(int Key : hm.keySet()){
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(Key,hm.get(Key)));
            pq.add(list);
        }
        while(!pq.isEmpty()){
            ArrayList<ArrayList<Integer>> al = new ArrayList<>();
            if (pq.size() < k) return false;
            for(int i=0;i<k;i++){
                ArrayList<Integer> removed = pq.poll();
                removed.set(1,removed.get(1)-1);
                al.add(removed);
            }
            for(int i=0;i<k-1;i++){
                if((al.get(i+1).get(0)-al.get(i).get(0))!=1){
                    return false;
                }
            }
            for(ArrayList<Integer> l : al){
                if(l.get(1)>0){
                    pq.add(l);
                }
            }          
        }
        return true;
    }
}