import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.minmaxGasDist(new int[]{23, 24, 36, 39, 46, 56, 57, 65, 84, 98}, 1));
    }

    public double minmaxGasDist(int[] stations, int k) {
        int maxGap = 0;
        for (int i = 1; i < stations.length; i++) {
            maxGap = Math.max(maxGap, stations[i] - stations[i - 1]);
        }
        double left = 0, right = maxGap;
        while (left < right - 1) {
            double mid = left + (right - left) / 2;
            if (canMeet(stations, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return canMeet(stations, k, left) ? left : right;
    }

    private boolean canMeet(int[] A, int k, double max) {
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            int gap = A[i] - A[i - 1];
            int temp = 1;
            while (gap / (double) temp > max) {
                temp++;
            }
            count += (temp - 1);
            if (count > k) {
                return false;
            }
        }
        return true;
    }
}
