package binary.search.tree.serialize.and.deserialize;

import binary.TreeNode;
import binary.TreeUtil;

public class Codec {

    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        traverseBST(root, sb);
        return sb.substring(0, sb.lastIndexOf("#"));
    }

    private void traverseBST(TreeNode node, StringBuffer sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val + "#");
        traverseBST(node.left, sb);
        traverseBST(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] items = data.split("#");
        TreeNode root = new TreeNode(Integer.valueOf(items[0]));
        for (int i = 1; i < items.length; i++) {
            preorderInsert(root, new TreeNode(Integer.valueOf(items[i])));
        }
        return root;
    }

    private void preorderInsert(TreeNode node, TreeNode insertNode) {
        while (node != insertNode) {
            if (insertNode.val < node.val) {
                if (node.left == null) {
                    node.left = insertNode;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = insertNode;
                }
                node = node.right;
            }
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(10);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(15);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        TreeUtil.preorderPrint(a);
        TreeNode node = codec.deserialize(codec.serialize(a));
        TreeUtil.preorderPrint(node);
    }
}

