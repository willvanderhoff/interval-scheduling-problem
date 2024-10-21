import java.util.Arrays;

class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Sort balloons by their end positions
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;  // Start by shooting one arrow
        int lastEnd = points[0][1];  // The position of the last arrow shot

        for (int i = 1; i < points.length; i++) {
            // If the start of the current balloon is after the last arrow shot,
            // we need a new arrow
            if (points[i][0] > lastEnd) {
                arrows++;
                lastEnd = points[i][1];  // Update the position of the new arrow shot
            }
        }

        return arrows;  // Return the minimum number of arrows required
    }
}
