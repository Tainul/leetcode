public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int p : piles) {
            max = Math.max(max, p);
        }
        int left = 1, right = max;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return canFinish(piles, h, left) ? left : right;
    }

    private boolean canFinish(int[] piles, int h, int bite) {
        int time = 0;
        for (int p : piles) {
            time += (p % bite == 0 ? p / bite : p / bite + 1);
        }
        return h >= time;
    }
}
