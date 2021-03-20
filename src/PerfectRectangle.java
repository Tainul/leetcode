import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        int[][] events = new int[rectangles.length * 2][4];
        int index = 0, OPEN = 0, CLOSE = 1;
        for (int[] r : rectangles) {
            events[index++] = new int[]{r[1], OPEN, r[0], r[2]};
            events[index++] = new int[]{r[3], CLOSE, r[0], r[2]};
        }
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> active = new ArrayList<>();
        Integer start = null, end = null, preY = null;
        for (int[] e : events) {
            int y = e[0], type = e[1], left = e[2], right = e[3];
            if (preY == null || y > preY) {
                for (int i = 0; i < active.size(); i++) {
                    if (start == null) {
                        start = active.get(0)[0];
                    } else if (start != active.get(0)[0]) {
                        return false;
                    }
                    if (i > 0 && active.get(i - 1)[1] != active.get(i)[0]) {
                        return false;
                    }
                    if (end == null) {
                        end = active.get(active.size() - 1)[1];
                    } else if (end != active.get(active.size() - 1)[1]) {
                        return false;
                    }
                }
            }
            if (type == OPEN) {
                active.add(new int[]{left, right});
                Collections.sort(active, (a, b) -> Integer.compare(a[0], b[0]));
            } else {
                for (int i = 0; i < active.size(); i++) {
                    if (active.get(i)[0] == left && active.get(i)[1] == right) {
                        active.remove(i);
                    }
                }
            }
            preY = y;
        }
        return true;
    }
}
