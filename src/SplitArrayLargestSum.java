public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        // find the upper bound of sum of each section.
        int sum = 0, max = 0;
        for (int n : nums) {
            sum += n;
            max = Math.max(max, n);
        }
        int left = max, right = sum;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (isValid(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return isValid(nums, m, left) ? left : right;
    }

    private boolean isValid(int[] A, int m, int maxPile) {
        int count = 0, curSum = 0;
        for (int a : A) {
            if (curSum + a <= maxPile) {
                curSum += a;
            } else {
                count++;
                curSum = a;
            }
        }
        if (curSum > 0) {
            count++;
        }
        return count <= m;
    }
}
