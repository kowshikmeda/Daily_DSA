class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer,int[]> row = new HashMap<>();
        Map<Integer,int[]> col = new HashMap<>();
        for(int i=0;i<buildings.length;i++){
            int x = buildings[i][0];
            int y = buildings[i][1];

            int[] ts1 = row.getOrDefault(x,new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});
            ts1[0] = Math.min(y,ts1[0]);
            ts1[1] = Math.max(ts1[1],y);
            row.put(x,ts1);

            int[] ts2 = col.getOrDefault(y,new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});
            ts2[0] = Math.min(x,ts2[0]);
            ts2[1] = Math.max(ts2[1],x);
            col.put(y,ts2);
        }
        int count = 0;
        for(int i=0;i<buildings.length;i++){
            int x = buildings[i][0];
            int y = buildings[i][1];
            int[] cols = row.get(x);
            int[] rows = col.get(y);
            if(x>rows[0] && x<rows[1] && y>cols[0] && y<cols[1]){
                count++;
            }
        }
        return count;


    }
}