package Tree;

public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        // #: +1, digit: -2
        int bal = -1;
        String[] splits = preorder.split(",");
        for (String s : splits) {
            if (++bal > 0) {
                return false;
            }
            if (!s.equals("#")) {
                bal -= 2;
            }
        }
        return bal == 0;
    }
}
