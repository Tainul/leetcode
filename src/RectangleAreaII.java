import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RectangleAreaII {
    public int rectangleArea(int[][] rectangles) {
        int[][] events = new int[rectangles.length * 2][4];
        int OPEN = 0, CLOSE = 1;
        int j = 0;
        for (int[] r : rectangles) {
            events[j++] = new int[]{r[1], OPEN, r[0], r[2]};
            events[j++] = new int[]{r[3], CLOSE, r[0], r[2]};
        }
        Arrays.sort(events, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        List<int[]> active = new ArrayList<>();
        long res = 0, preY = 0;
        for (int[] e : events) {
            int y = e[0], type = e[1], left = e[2], right = e[3];
            int cur = -1;
            long length = 0;
            for (int[] a : active) {
                cur = Math.max(cur, a[0]);
                length += Math.max(a[1] - cur, 0);
                cur = Math.max(cur, a[1]);
            }
            res += length * (y - preY);
            if (type == OPEN) {
                active.add(new int[]{left, right});
                Collections.sort(active, (a, b) -> Integer.compare(a[0], b[0]));
            } else {
                for (int i = 0; i < active.size(); i++) {
                    if (active.get(i)[0] == left && active.get(i)[1] == right) {
                        active.remove(i);
                        break;
                    }
                }
            }
            preY = y;
        }
        return (int) (res % 1000000007);
    }
}
