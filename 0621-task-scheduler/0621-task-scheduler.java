class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] frq = new int[26];

        // Count frequency of each task
        for (char ch : tasks) {
            frq[ch - 'A']++; // mapping 'A'-'Z' to 0-25
        }

        // Max heap to prioritize tasks with highest frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int e : frq) {
            if (e > 0) {
                pq.add(e);
            }
        }

        int t = 0; // total time

        // Continue until all tasks are scheduled
        while (!pq.isEmpty()) {
            boolean isLast = true;           // flag to check if this is the last batch
            int timesToPop = n + 1;          // number of tasks allowed in this round (cooldown + 1)
            List<Integer> list = new ArrayList<>(); // to store remaining frequencies after executing

            // Try to schedule up to (n + 1) tasks
            while (timesToPop > 0 && !pq.isEmpty()) {

                if ((pq.peek() - 1) != 0) {
                    isLast = false; // there's still some task left
                }

                list.add(pq.poll() - 1); // execute the task and decrease frequency
                timesToPop--;
            }

            // Calculate time
            if (isLast) {
                t += ((n + 1) - (timesToPop)); // add only the time taken (no idle needed)
            } else {
                t += n + 1; // full cycle (may include idle time)
            }

            // Add remaining tasks back into the priority queue
            for (int e : list) {
                if (e > 0) {
                    pq.add(e);
                }
            }
        }

        return t;
    }
}