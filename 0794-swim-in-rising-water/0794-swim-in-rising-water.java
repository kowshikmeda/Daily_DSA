class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // {elevation, row, col}
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        int[][] dirs = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        int time = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int ele = curr[0], x = curr[1], y = curr[2];
            time = Math.max(time, ele);
            if(x == n-1 && y == n-1) return time;

            grid[x][y] = (int)1e9; // mark visited

            for(int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] != (int)1e9) {
                    pq.offer(new int[]{grid[nx][ny], nx, ny});
                }
            }
        }
        
        return 0;
    }
}