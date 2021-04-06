package Tree;

import java.util.HashMap;
import java.util.Map;


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


public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1, 0, map);
    }

    private TreeNode dfs(int[] preorder, int inLeft, int inRight, int preLeft, Map<Integer, Integer> map) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int leftSize = map.get(preorder[preLeft]) - inLeft;
        root.left = dfs(preorder, inLeft, inLeft + leftSize - 1, preLeft + 1, map);
        root.right = dfs(preorder, inLeft + leftSize + 1, inRight, preLeft + leftSize + 1, map);
        return root;
    }
}
