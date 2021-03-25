import java.util.HashMap;
import java.util.Map;

public class NumberofWaysWhereSquareofNumberisEqualtoProductofTwoNumbers {
    public int numTriplets(int[] nums1, int[] nums2) {
        return findNum(nums1, nums2) + findNum(nums2, nums1);
    }

    private int findNum(int[] nums1, int[] nums2) {
        Map<Long, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            long a = (long) nums1[i] * nums1[i];
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (int i = 0; i < nums2.length - 1; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                long temp = (long) nums2[i] * nums2[j];
                if (map.containsKey(temp)) {
                    res += map.get(temp);
                }
            }
        }
        return res;
    }
}
