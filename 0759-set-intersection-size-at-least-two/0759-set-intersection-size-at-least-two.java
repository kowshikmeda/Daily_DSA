class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
         PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for (int[] in : intervals) {
            queue.offer(in);
        }
        int ans = 2;//look below how int[] check is initialized
        int[] check = new int[] {queue.peek()[1] - 1, queue.peek()[1]};
        while(!queue.isEmpty()) {
            int[] interval = queue.poll();
            if (interval[0] <= check[1] && interval[1] >= check[1]) {
                if (interval[0] <= check[0] && interval[1] >= check[0]) {//[1,5],[4,11]...[4,5]
                    continue;
                } else {    //[1,5],[5,11]
                    ans++;
                    if (interval[1] == check[1]) {
                        check[0] = check[1] - 1;
                    } else {
                        check[0] = check[1];
                        check[1] = interval[1];
                    }
                    // int temp = check[1];    // bug...intervals =[[1,3],[3,7],[5,7],[7,8]]  Output4 Expected5
                    // check[0] = temp;
                    // check[1] = interval[1];
                }
            } else {//[1,5],[8,15],[13,16] =>>check[14,15],[13,16]...
                check[1] = interval[1];
                check[0] = interval[1] - 1;
                ans += 2;
            }
        }
        return ans;
    }
}