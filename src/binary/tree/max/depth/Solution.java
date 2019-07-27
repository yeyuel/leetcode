package binary.tree.max.depth;

import binary.TreeNode;

public class Solution {

    public int maxDepth(TreeNode root) {
        return preorder(root, 1);
    }

    private int preorder(TreeNode node, int current) {
        if (node == null) {
            return  0;
        }
        if (node.left == null && node.right == null) {
            return current;
        }
        int leftDepth = 0;
        if (node.left != null) {
            leftDepth = preorder(node.left, current + 1);
        }
        int rightDepth = 0;
        if (node.right != null) {
            rightDepth = preorder(node.right, current + 1);
        }
        return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b1 = new TreeNode(9);
        TreeNode b2 = new TreeNode(20);
        TreeNode c3 = new TreeNode(15);
        TreeNode c4 = new TreeNode(7);

        a.left = b1;
        a.right = b2;
        b2.left = c3;
        b2.right = c4;

        System.out.println(new Solution().maxDepth(a));
    }
}
