public class FindtheSmallestDivisorGivenaThreshold {
    public int smallestDivisor(int[] nums, int t) {
        int left = 1, right = (int) 1e6;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (canFit(nums, t, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return canFit(nums, t, left) ? left : right;
    }

    private boolean canFit(int[] A, int t, int d) {
        int sum = 0;
        for (int a : A) {
            sum += (a + d - 1) / d;
        }
        return sum <= t;
    }
}
