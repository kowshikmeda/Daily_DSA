class pair{
    int r,c;
    pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public boolean possible(int [][]cells, int r, int c, int day){
        //HashSet<String> h =new HashSet<>();
        boolean visited[][] = new boolean[r+1][c+1];
        for(int i=0; i<day; i++){
            // String key =String.valueOf(cells[i][0]) +'#' + String.valueOf(cells[i][1]);
            // h.add(key);
            visited[cells[i][0]][cells[i][1]] = true;
        }
        Queue<pair> q = new ArrayDeque<>();
        for(int i=0; i<=c; i++){
            // String key ='0'+'#' + String.valueOf(i);
            if(visited[0][i]) continue;
            q.add(new pair(0,i));
        }
        int row[] = {0,0,-1,1};
        int col[] = {-1,1,0,0};
        while(!q.isEmpty()){
            pair curr = q.poll();
            if(curr.r == r) return true;
            for(int i=0; i<4; i++){
                int nr = row[i] + curr.r;
                int nc = col[i] + curr.c;
                if(nr <=0 || nc<=0 || nr > r || nc> c || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                q.add(new pair(nr, nc));
            }
        }
        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int st = col - 1;
        int end = row*col - 1;
        int ans = 0;
        while(st <= end){
            int mid = (st + end)>>1;
            if(possible(cells, row, col, mid)) {ans = mid; st = mid+1;}
            else end = mid-1;
        }
        return ans;
    }
}