import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
    }

    public List<List<Integer>> numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, new Integer[1], new int[]{target}, new int[]{0}, cur, res, target);
        System.out.println(res.size());
        return res;
    }

    private void dfs(int[] nums, int index, Integer[] min, int[] remain, int[] count, List<Integer> cur, List<List<Integer>> res, int target) {
        if (index == nums.length) {
            if (count[0] != 1 || remain[0] >= (int) Math.ceil(target / 2.0)) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            //add
            Integer minTemp = min[0];
            int remainTemp = remain[0], countTemp = count[0];
            if (remain[0] >= nums[i]) {

                if (min[0] == null) {
                    min[0] = nums[i];
                }
                remain[0] -= nums[i];
                count[0]++;
                cur.add(nums[i]);
            }
            dfs(nums, i + 1, min, remain, count, cur, res, target);
            min[0] = minTemp;
            remain[0] = remainTemp;
            if (count[0] > countTemp) {
                count[0] = countTemp;
                cur.remove(cur.size() - 1);
            }

        }


    }

}
