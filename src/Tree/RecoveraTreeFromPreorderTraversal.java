package Tree;

public class RecoveraTreeFromPreorderTraversal {
    public TreeNode recoverFromPreorder(String S) {

        return dfs(0, new int[]{0}, S);
    }

    private TreeNode dfs(int depth, int[] index, String s) {
        int d = 0;
        while (index[0] + d < s.length() && s.charAt(index[0] + d) == '-') {
            d++;
        }
        if (d != depth) {
            return null;
        }
        int next = index[0] + d;
        while (next < s.length() && s.charAt(next) != '-') {
            next++;
        }
        int val = Integer.parseInt(s.substring(index[0] + d, next));
        TreeNode node = new TreeNode(val);
        index[0] = next;
        node.left = dfs(depth + 1, index, s);
        node.right = dfs(depth + 1, index, s);
        return node;
    }
}
