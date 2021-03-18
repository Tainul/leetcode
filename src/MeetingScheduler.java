import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<int[]> list = new ArrayList<>();
        for (int[] s : slots1) {
            list.add(s);
        }
        for (int[] s : slots2) {
            list.add(s);
        }
        int[][] array = list.toArray(new int[list.size()][2]);
        Arrays.sort(array, (a1, a2) -> Integer.compare(a1[0], a2[0]));
        List<Integer> res = new ArrayList<>();
        Integer end = null;
        for (int[] a : array) {
            if (end == null) {
                end = a[1];
            } else if (a[0] + duration <= end && a[0] + duration <= a[1]) {
                res.add(a[0]);
                res.add(a[0] + duration);
                return res;
            } else {
                end = Math.max(end, a[1]);
            }
        }
        return res;
    }
}
