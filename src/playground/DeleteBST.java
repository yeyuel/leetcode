package playground;

class TreeNode{
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class DeleteBST {

    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    public int predecessor(TreeNode root) {
        root = root.left;
        while (root != null) root = root.right;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key > root.val) root.right = deleteNode(root.right, key);
        else if (key < root.val) root.left = deleteNode(root.left, key);
        else {
            if (root.left == null && root.right == null) root = null;
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    public TreeNode buildBST (int[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            TreeNode newNode = new TreeNode(arr[i]);
            TreeNode cur = root;
            while (cur != newNode) {
                if (newNode.val <= cur.val) {
                    if (cur.left == null) {
                        cur.left = newNode;
                    }
                    cur = cur.left;
                } else {
                    if (cur.right == null) {
                        cur.right = newNode;
                    }
                    cur = cur.right;
                }
            }
        }
        return root;
    }

    public void printTree (TreeNode root, int level) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.print(root.val);
        System.out.println();
        printTree(root.left, level + 1);
        printTree(root.right, level + 1);
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 6, 8, 7};
        DeleteBST deleteBST = new DeleteBST();
        TreeNode root = deleteBST.buildBST(arr);
        deleteBST.printTree(root, 0);
        deleteBST.deleteNode(root, 6);
        deleteBST.printTree(root, 0);
    }

}
