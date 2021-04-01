public class MinimumNumberofDaystoMakemBouquets {
    public int minDays(int[] b, int m, int k) {
        if (b.length < m * k) {
            return -1;
        }
        int max = 0;
        for (int i : b) {
            max = Math.max(max, i);
        }
        int left = 0, right = max;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (canMake(b, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return canMake(b, m, k, left) ? left : right;
    }

    private boolean canMake(int[] b, int m, int k, int days) {
        int count = 0;
        int continuous = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] <= days) {
                continuous++;
                if (continuous == k) {
                    count++;
                    continuous = 0;
                }
            } else {
                continuous = 0;
            }
        }
        return count >= m;
    }
}
