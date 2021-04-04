public class MinimizeMaxDistancetoGasStation {
    public double minmaxGasDist(int[] stations, int k) {
        int maxGap = 0;
        for (int i = 1; i < stations.length; i++) {
            maxGap = Math.max(maxGap, stations[i] - stations[i - 1]);
        }
        double left = 0, right = maxGap;
        while (left + 1e-6 < right) {
            double mid = left + (right - left) / 2;
            if (canMeet(stations, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean canMeet(int[] A, int k, double max) {
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            double gap = A[i] - A[i - 1];
            count += (Math.ceil(gap / max) - 1);
        }
        return count <= k;
    }
}
