public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D) {
        int sum = 0, max = 0;
        for (int w : weights) {
            sum += w;
            max = Math.max(max, w);
        }
        int left = max, right = sum;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (canMeet(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return canMeet(weights, D, left) ? left : right;
    }

    private boolean canMeet(int[] A, int d, int c) {
        int count = 1, curSum = 0;
        for (int a : A) {
            if (curSum + a <= c) {
                curSum += a;
            } else {
                curSum = a;
                count++;
            }
        }
        return count <= d;
    }
}
