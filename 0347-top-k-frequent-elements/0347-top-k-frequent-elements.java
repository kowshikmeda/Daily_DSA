class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //logic is we require top k freq elements
        //keep track of element and its freq
        //we need min heap
        
        Map<Integer, Integer> count = new HashMap();
        
        for (int n: nums) {
          count.put(n, count.getOrDefault(n, 0) + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));
    

        for (int n: count.keySet()) {
          minHeap.add(n);
          if (minHeap.size() > k) minHeap.poll();    
        }
        
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = minHeap.poll();
        }
        return top;
    }
}