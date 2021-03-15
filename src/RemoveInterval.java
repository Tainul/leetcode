import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveInterval {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] remove) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] i : intervals) {
            if (i[0] < remove[0]) {
                res.add(Arrays.asList(i[0], Math.min(i[1], remove[0])));
            }
            if (i[1] > remove[1]) {
                res.add(Arrays.asList(Math.max(i[0], remove[1]), i[1]));
            }
        }
        return res;
    }
}
