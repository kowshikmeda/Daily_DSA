import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Step 1: Add all intervals that end before the new interval starts.
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals.
        while (i < n && intervals[i][0] <= newInterval[1]) {
            // Update the start of newInterval to the minimum of its current start and the current interval's start.
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            // Update the end of newInterval to the maximum of its current end and the current interval's end.
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the merged newInterval to the result list.
        result.add(newInterval);

        // Step 3: Add all remaining intervals.
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}