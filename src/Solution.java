import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0; // Count of overlapping intervals
        int lastEnd = intervals[0][1]; // End time of the last non-overlapping interval

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                // If there is an overlap, increment the count
                count++;
            } else {
                // Update lastEnd for non-overlapping intervals
                lastEnd = intervals[i][1];
            }
        }

        return count; // Number of intervals to remove
    }
}

