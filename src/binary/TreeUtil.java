package binary;

public class TreeUtil {

    public static void preorderPrint(TreeNode root) {
        preorderPrint(root, 0);
    }

    private static void preorderPrint(TreeNode node, int layer) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < layer; i++) {
            System.out.printf("----");
        }
        System.out.printf("[%d]\n", node.val);
        preorderPrint(node.left, layer + 1);
        preorderPrint(node.right, layer + 1);
    }
}
