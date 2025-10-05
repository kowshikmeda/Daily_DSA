class Solution {
    static int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    int m,n;
    public void dfs(int[][] heights,int row, int col, boolean[][] ocean){
        ocean[row][col]=true;
        for(int[] d:dirs){
            int newR=row+d[0];
            int newC=col+d[1];
            if(newR<0 || newC<0 || newR>=m || newC>=n)continue;
            if(ocean[newR][newC])continue;
            if(heights[newR][newC]<heights[row][col])continue;
            dfs(heights,newR,newC,ocean);
        }

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //Start DFS/BFS from the oceans and mark which cells can reach them.
        // Once we know: // Cells reachable from Pacific ans // Cells reachable from Atlantic ->// → Their intersection gives cells that can flow to both oceans.
        List<List<Integer>> ans=new ArrayList<>();
        m=heights.length;
        n=heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        //DFS for pacific(top+left)
        for(int i=0;i<m;i++){
            dfs(heights,i,0,pacific);
        }
        for (int j = 0; j < n; j++){
            dfs(heights, 0, j, pacific);
        }
        //DFS for atlantic(right+bottom)
        for(int i = 0; i < m; i++){
            dfs(heights, i, n - 1, atlantic);
        }
        for(int j = 0; j < n; j++){
            dfs(heights,m - 1, j, atlantic);
        }
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
}