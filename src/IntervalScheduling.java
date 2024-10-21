import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IntervalScheduling {
    public List<int[]> intervalScheduling(int[][] intervals) {
        if (intervals.length == 0) return new ArrayList<>();

        // Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        List<int[]> A = new ArrayList<>();  // Set of accepted requests
        A.add(intervals[0]);  // Add the first interval
        int lastEnd = intervals[0][1];  // End time of the last accepted interval

        for (int i = 1; i < intervals.length; i++) {
            // If the current interval is compatible (start >= last selected end)
            if (intervals[i][0] >= lastEnd) {
                A.add(intervals[i]);  // Add interval to A
                lastEnd = intervals[i][1];  // Update lastEnd
            }
        }

        return A;  // Return the set of accepted requests
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 4}, {3, 5}, {4, 9}, {7, 8}};
        IntervalScheduling scheduler = new IntervalScheduling();
        List<int[]> acceptedRequests = scheduler.intervalScheduling(intervals);

        System.out.println("Accepted intervals:");
        for (int[] interval : acceptedRequests) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
