import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[1], p2[1]));
        int count = 0;
        Integer end = null;
        for (int[] p : points) {
            if (end == null || p[0] > end) {
                count++;
                end = p[1];
            }
        }
        return count;
    }
}
