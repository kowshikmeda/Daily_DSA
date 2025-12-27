class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]);

        int[] rooms = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] == b[1] ? a[2]-b[2] : a[1]-b[1]));
        PriorityQueue<Integer> set = new PriorityQueue<>();

        for(int i =0;i<n;i++) set.add(i);

        for(int i =0;i<meetings.length;i++){
            int[] meeting = meetings[i];

            while(!pq.isEmpty() && pq.peek()[1] <= meeting[0]){
                int[] ending = pq.remove();
                set.add(ending[2]);
            }

            if(set.isEmpty()){
                int[] ending = pq.remove();
                int room = ending[2];
                int[] temp = {ending[1], meeting[1]+(ending[1]-meeting[0]), room};
                rooms[room]++;
                pq.add(temp);
            }else{
                int room = set.remove();
                rooms[room]++;
                int[] temp = {meeting[0], meeting[1], room};
                pq.add(temp);
            }


        }

        int max = Integer.MIN_VALUE;
        int room = -1;

        for(int i =0;i<n;i++){
            if(rooms[i] > max){
                max = rooms[i];
                room = i;
            }
        }

        return room;

        
    }
}