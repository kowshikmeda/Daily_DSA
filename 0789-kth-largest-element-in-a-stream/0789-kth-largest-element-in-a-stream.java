class KthLargest {
    public PriorityQueue<Integer>queue;
    public int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.queue=new PriorityQueue<>();
        for(int num:nums){
            add(num);
        }
    }  
    public int add(int val) {
        queue.offer(val);
        if(queue.size()>k){
            queue.poll();
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */