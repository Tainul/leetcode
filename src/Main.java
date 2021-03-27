import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.maxSum(new int[]{1, 3, 5, 7, 9}, new int[]{3, 5, 100}));
    }

    public int maxSum(int[] nums1, int[] nums2) {
        // find the common numbers of two arrays
        // divide each array into multiple sections by common numbers ans save them into map [number, sum]
        // add them up
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            int a = nums1[i], b = nums2[j];
            if (a < b) {
                i++;
            } else if (a > b) {
                j++;
            } else {
                map.put(a, a);
                i++;
                j++;
            }
        }
        int k = 0;
        while (k < nums1.length) {
            int n = nums1[k];
            if (k == 0 || map.containsKey(n)) {
                if (k != 0) k++;
                int curSum = k == 0 ? 0 : map.get(n);
                while (k < nums1.length && !map.containsKey(nums1[k])) {
                    curSum += nums1[k];
                    k++;
                }
                if (!map.containsKey(n)) {
                    map.put(0, curSum);
                } else {
                    map.put(n, curSum);
                }
            }
        }
        k = -1;
        while (k < nums2.length) {
            int n = k == -1 ? -1 : nums2[k];
//            if (k == 0 && map.containsKey(n)) {
//                k++;
//            }
            if (k == -1 || map.containsKey(n)) {
                int curSum = k == -1 ? 0 : n;
                k++;
                while (k < nums2.length && !map.containsKey(nums2[k])) {
                    curSum += nums2[k];
                    k++;
                }
                if (!map.containsKey(n)) {
                    map.put(0, Math.max(curSum, map.get(0)));
                } else {
                    map.put(n, Math.max(curSum, map.get(n)));
                }
            }
            if (k != 0) k++;
        }

        int res = 0;
        for (int v : map.values()) {
            res += v;
        }
        return res;
    }
}
