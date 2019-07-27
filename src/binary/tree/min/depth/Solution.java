package binary.tree.min.depth;

import binary.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        return preorder(root, 1);
    }

    private int preorder(TreeNode node, int level) {
        if (node == null) {
            return  0;
        }
        if (node.left == null && node.right == null) {
            return level;
        }
        int leftLevel = 0, rightLevel = 0;
        if (node.left != null) {
            leftLevel = preorder(node.left, level + 1);
        }
        if (node.right != null) {
            rightLevel = preorder(node.right, level + 1);
        }
        if (leftLevel == 0) {
            return rightLevel;
        }
        if (rightLevel == 0) {
            return leftLevel;
        }
        return Math.min(leftLevel, rightLevel);
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

        System.out.println(new Solution().minDepth(a));
    }
}
