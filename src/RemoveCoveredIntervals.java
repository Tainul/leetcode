import java.util.Arrays;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = 0;
        Integer end = null;
        Arrays.sort(intervals, (i1, i2) -> (i1[0] != i2[0] ? i1[0] - i2[0] : i2[1] - i1[1]));
        for (int[] i : intervals) {
            if (end == null || i[1] > end) {
                count++;
                end = i[1];
            }
        }
        return count;
    }
}
