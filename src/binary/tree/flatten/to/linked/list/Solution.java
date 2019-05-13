package binary.tree.flatten.to.linked.list;

import binary.TreeNode;

public class Solution {

    public void flatten(TreeNode root) {
        preorder(root);
    }

    private TreeNode preorder(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        TreeNode leftLast = null;
        TreeNode last = null;
        if (left != null) {
            leftLast = preorder(left);
            node.left = null;
            node.right = left;
            last = leftLast;
        }
        if (right != null) {
            last = preorder(right);
            if (leftLast != null) {
                leftLast.right = right;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(6);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        Solution solution = new Solution();
        solution.flatten(a);

        TreeNode current = a;
        while (current != null) {
            System.out.printf("[%d] ", current.val);
            current = current.right;
        }
    }
}
