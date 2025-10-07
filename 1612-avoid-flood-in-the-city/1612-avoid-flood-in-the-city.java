class IntPair implements Comparable<IntPair> {
    int key;
    int value;

    public IntPair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(IntPair other) {
        // Min-heap based on key
        return Integer.compare(this.key, other.key);
    }
}

class Solution {
    public int[] avoidFlood(int[] rains) {
        final int n = rains.length;
        int[] ans = new int[n];

        // Find next rainy day for current day and lake
        int[] nextRains = new int[n];
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = n - 1; i >= 0; --i) {
            if (rains[i] == 0) continue;

            if (m.containsKey(rains[i])) {
                nextRains[i] = m.get(rains[i]);
            }
            m.put(rains[i], i);
        }

        PriorityQueue<IntPair> pq = new PriorityQueue<>();

        for (int i = 0; i < n; ++i) {
            ans[i] = -1;
            if (rains[i] > 0 && nextRains[i] > 0) {
                pq.offer(new IntPair(nextRains[i], rains[i]));
            } else if (rains[i] == 0) {
                if (!pq.isEmpty()) {
                    IntPair p = pq.poll();
                    if (i < p.getKey()) {
                        ans[i] = p.getValue();
                    } else {
                        return new int[0];
                    }
                } else {
                    ans[i] = 1;
                }
            }
        }

        if (pq.isEmpty()) {
            return ans;
        }

        return new int[0];
    }
}