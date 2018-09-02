package binary.search.tree.convert.bst.greater.tree;

import binary.TreeNode;
import binary.TreeUtil;

public class Solution {

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        travelTree(root, sum);
        return root;
    }

    private int travelTree(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        sum = travelTree(node.right, sum);
        sum += node.val;
        node.val = sum;
        return travelTree(node.left, sum);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(13);
        a.left = b; a.right = c;
        Solution solution = new Solution();
        TreeUtil.preorderPrint(solution.convertBST(a));
    }
}
