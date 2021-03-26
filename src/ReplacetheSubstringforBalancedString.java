public class ReplacetheSubstringforBalancedString {
    public int balancedString(String s) {
        int n = s.length(), cap = n / 4;
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int left = 0, right = 0, res = n;
        while (right < n) {
            count[s.charAt(right)]--;
            while (left < n && count['Q'] <= cap && count['W'] <= cap && count['E'] <= cap && count['R'] <= cap) {
                res = Math.min(res, right - left + 1);
                count[s.charAt(left++)]++;
            }
            right++;
        }
        return res;
    }
}
