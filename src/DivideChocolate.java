public class DivideChocolate {
    public int maximizeSweetness(int[] sweetness, int K) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int s : sweetness) {
            min = Math.min(min, s);
            sum += s;
        }
        int left = min, right = sum / (K + 1);
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (canMeet(sweetness, K, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return canMeet(sweetness, K, right) ? right : left;
    }

    private boolean canMeet(int[] A, int k, int min) {
        int cur = 0, count = 0;
        for (int a : A) {
            if (cur + a >= min) {
                count++;
                cur = 0;
            } else {
                cur += a;
            }
        }
        return count >= k + 1;
    }
}
