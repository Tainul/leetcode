package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipBinaryTreeToMatchPreorderTraversal {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] v) {
        List<Integer> res = new ArrayList<>();
        return dfs(root, v, new int[]{0}, res) ? res : Arrays.asList(-1);
    }

    public Boolean dfs(TreeNode node, int[] v, int[] index, List<Integer> res) {
        if (node == null) return true;
        if (node.val != v[index[0]++]) return false;
        if (node.left != null && node.left.val != v[index[0]]) {
            res.add(node.val);
            return dfs(node.right, v, index, res) && dfs(node.left, v, index, res);
        }
        return dfs(node.left, v, index, res) && dfs(node.right, v, index, res);
    }
}
