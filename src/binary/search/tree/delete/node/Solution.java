package binary.search.tree.delete.node;

import binary.TreeNode;
import binary.TreeUtil;

public class Solution {


    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode[] result = bstSearch(root, key);
        TreeNode parent = result[0];
        TreeNode node = result[1];
        if (node == null) {
            return root;
        }
        // include root node with both left and right children
        if (node.left != null && node.right != null) {
            TreeNode[] successorRet = findSuccessor(node);
            TreeNode successor = successorRet[1];
            deleteNode(successorRet[0], successor);
            node.val = successor.val;
            return root;
        }
        if (parent != null) {
            deleteNode(parent, node);
            return root;
        }
        // is root node
        if (node.left != null) {
            root = node.left;
        } else {
            root = node.right;
        }
        return root;
    }

    private void deleteNode(TreeNode parent, TreeNode node) {
        if (node.val < parent.val) {
            if (node.left != null && node.right == null) {
                parent.left = node.left;
            } else if (node.left == null && node.right != null) {
                parent.left = node.right;
            } else {
                parent.left = null;
            }
        } else if (node.val > parent.val) {
            if (node.left != null && node.right == null) {
                parent.right = node.left;
            } else if (node.left == null && node.right != null) {
                parent.right = node.right;
            } else {
                parent.right = null;
            }
        }
    }

    private TreeNode[] bstSearch(TreeNode node, int value) {
        TreeNode parent = null;
        while (node != null) {
            if (node.val == value) {
                break;
            }
            parent = node;
            if (value < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return new TreeNode[]{parent, node};
    }

    private TreeNode[] findSuccessor(TreeNode node) {
        TreeNode parent = node;
        TreeNode ptr = node.right;
        while (ptr.left != null) {
            parent = ptr;
            ptr = ptr.left;
        }
        return new TreeNode[]{parent, ptr};
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        for (int i = 1; i < 7; i++) {
            TreeNode a = new TreeNode(5);
            TreeNode b = new TreeNode(3);
            TreeNode c = new TreeNode(6);
            TreeNode d = new TreeNode(2);
            TreeNode e = new TreeNode(4);
            TreeNode f = new TreeNode(7);
            a.left = b;
            a.right = c;
            b.left = d;
            b.right = e;
            c.right = f;
            System.out.println("key=" + i);
            TreeNode ret = solution.deleteNode(a, i);
            TreeUtil.preorderPrint(ret);
            System.out.println();
        }
    }
}
