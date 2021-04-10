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
        System.out.println(main.recoverFromPreorder("1-2--3--4-5--6--7"));
    }

    public TreeNode recoverFromPreorder(String S) {
        TreeNode root = new TreeNode(S.charAt(0) - '0');
        dfs(root, 0, new int[]{1}, S);
        return root;
    }

    private TreeNode dfs(TreeNode root, int depth, int[] index, String s) {
        if (root == null) {
            return null;
        }
        int d = 0;
        while (s.charAt(index[0]) == '-') {
            d++;
            index[0]++;
        }
        if (d < depth + 1) {
            return null;
        }
        TreeNode node = new TreeNode(s.charAt(index[0]) - '0');
        index[0]++;
        if (root.left == null) {
            root.left = node;
            dfs(root.left, depth + 1, index, s);
        } else if (root.right == null) {
            root.right = node;
            dfs(root.right, depth + 1, index, s);
        }
        return node;
    }
}
