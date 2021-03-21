import java.util.*;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int[][] events = new int[buildings.length * 2][2]; // x, y, type
        int index = 0, OPEN = 0, CLOSE = 1;
        for (int[] b : buildings) {
            events[index++] = new int[]{b[0], -b[2]};
            events[index++] = new int[]{b[1], b[2]};
        }
        Arrays.sort(events, (a, b) -> (a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])));
        List<List<Integer>> res = new ArrayList<>();
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int preY = 0, preX = -1;
        for (int[] e : events) {
            int x = e[0], y = e[1];
            if (y < 0) {
                pq.offer(-y);
            } else {
                pq.remove(y);
            }
            int cur = pq.peek();
            if (preY != cur) {
                res.add(Arrays.asList(x, cur));
                preY = cur;
            }
        }
        return res;
    }
}
