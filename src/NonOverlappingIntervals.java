import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        Integer end = null;
        // if two intervals overlap, remove the one with bigger end, increase the count by 1, update the end
        for (int[] i : intervals) {
            if (end == null || i[0] >= end) {
                end = i[1];
            } else {
                end = Math.min(end, i[1]);
                count++;
            }
        }
        return count;
    }
}
