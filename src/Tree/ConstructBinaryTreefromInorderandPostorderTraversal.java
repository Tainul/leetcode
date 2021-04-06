package Tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(postorder, 0, inorder.length - 1, postorder.length - 1, map);
    }

    private TreeNode dfs(int[] postorder, int inLeft, int inRight, int postRight, Map<Integer, Integer> map) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postRight]);
        int rightSize = inRight - map.get(root.val);
        root.right = dfs(postorder, inRight - rightSize + 1, inRight, postRight - 1, map);
        root.left = dfs(postorder, inLeft, inRight - rightSize - 1, postRight - rightSize - 1, map);
        return root;
    }
}
