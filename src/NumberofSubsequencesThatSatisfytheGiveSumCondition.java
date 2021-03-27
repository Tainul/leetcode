import java.util.Arrays;

public class NumberofSubsequencesThatSatisfytheGiveSumCondition {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] pows = new int[n];
        int mod = 1000000007;
        pows[0] = 1;
        for (int i = 1; i < n; i++) {
            pows[i] = pows[i - 1] * 2 % mod;
        }
        int l = 0, r = n - 1, res = 0;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                res = (res + pows[r - l++]) % mod;
            } else {
                r--;
            }
        }
        return res;
    }
}
