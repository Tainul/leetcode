public class MaximumScoreofaGoodSubarray {
    public int maximumScore(int[] A, int k) {
        int i = k, j = k, res = A[k], min = A[k];
        while (i > 0 || j < A.length - 1) {
            if (i == 0) {
                j++;
            } else if (j == A.length - 1) {
                i--;
            } else if (A[i - 1] < A[j + 1]) {
                j++;
            } else {
                i--;
            }
            min = Math.min(min, Math.min(A[i], A[j]));
            res = Math.max(res, min * (j - i + 1));

        }
        return res;
    }
}
