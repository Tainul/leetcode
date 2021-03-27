public class GettheMaximumScore {
    public int maxSum(int[] nums1, int[] nums2) {
        long a = 0, b = 0, mod = 1000000007;
        int m = nums1.length, n = nums2.length, i = 0, j = 0;
        while (i < m || j < n) {
            if (i < m && (j == n || nums1[i] < nums2[j])) {
                a += nums1[i++];
            } else if (j < n && (i == m || nums2[j] < nums1[i])) {
                b += nums2[j++];
            } else {
                a = b = Math.max(a, b) + nums1[i];
                i++;
                j++;
            }
        }
        return (int) (Math.max(a, b) % mod);
    }
}
