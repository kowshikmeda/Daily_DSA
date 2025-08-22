class Solution {
    public int[][] merge(int[][] intervals) {
         List<int[]> list = new ArrayList<>();
        if(intervals.length==0){
            return list.toArray(new int[0][]);
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end = Math.max(intervals[i][1],end);
            }else{
                list.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[]{start,end});
        return list.toArray(new int[0][]);
    }
}