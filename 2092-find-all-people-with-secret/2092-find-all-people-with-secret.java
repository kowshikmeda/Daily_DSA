class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b)->a[2]-b[2]);
        int m = meetings.length;
        int i = 0;
        Set<Integer> res = new HashSet<>();
        res.add(0);
        res.add(firstPerson);
        while (i < m) {
            int start = i;
            int currTime = meetings[i][2];
            // get all meeting of current time 
            while(i < m && meetings[i][2] == currTime) i++;

            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int j = start; j < i; j++) {
                int a = meetings[j][0], b = meetings[j][1];
                map.putIfAbsent(a, new HashSet<>());
                map.putIfAbsent(b, new HashSet<>());
                map.get(a).add(b);
                map.get(b).add(a);
            }

            Queue<Integer> q = new LinkedList<>();
            // Starting from known person
            for (int p: map.keySet()) {
                if (res.contains(p)) q.add(p);
            }
            while(!q.isEmpty()) {
                int curr = q.poll();
                for (int nei: map.get(curr)) {
                    if (!res.contains(nei)) {
                        q.add(nei);
                        res.add(nei);
                    }
                }
            }
        }
        return new ArrayList(res);
    }
}