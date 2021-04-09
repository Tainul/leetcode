import java.util.*;
import java.util.stream.Collectors;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(3);
        System.out.println(main.flipMatchVoyage(root, new int[]{2, 1}));
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        // parent and left or right
        Map<Integer, int[]> map = new HashMap<>();
        int LEFT = -1, RIGHT = 1;
        int[] origin = new int[voyage.length];
        dfs(null, root, new int[]{-1}, map);
        List<Integer> res = new ArrayList<>();
        //parent is key, order is value
        Map<Integer, Integer> orderMap = new HashMap<>();
        boolean consistent = true;
        for (int i = 0; i < voyage.length; i++) {
            int v = voyage[i];
            if (map.containsKey(v)) {
                if (map.get(v)[1] != i) {
                    consistent = false;
                }
                if (orderMap.containsKey(map.get(v)[0])) {
                    if (map.get(v)[1] < orderMap.get(map.get(v)[0])) {
                        res.add(map.get(v)[0]);
                    }
                } else {
                    orderMap.put(map.get(v)[0], map.get(v)[1]);
                }
            }
        }
        return (consistent || res.size() != 0) ? res : Arrays.asList(-1);
    }

    private void dfs(TreeNode parent, TreeNode node, int[] index, Map<Integer, int[]> map) {
        if (node == null) {
            return;
        }
        index[0]++;
        if (parent != null) {
            map.put(node.val, new int[]{parent.val, index[0]});
        }
        dfs(node, node.left, index, map);
        dfs(node, node.right, index, map);
    }
}
