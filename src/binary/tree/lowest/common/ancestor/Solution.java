package binary.tree.lowest.common.ancestor;

import binary.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> path = new LinkedList<>();
        List<TreeNode> resultP = new LinkedList<>();
        List<TreeNode> resultQ = new LinkedList<>();
        boolean finish = false;
        searchPath(root, p, path, resultP, finish);
        path.clear();
        searchPath(root, q, path, resultQ, finish);
        int pathLength = resultP.size() < resultQ.size() ? resultP.size() : resultQ.size();
        TreeNode result = null;
        for (int i = 0; i < pathLength; i++) {
            if (resultP.get(i) == resultQ.get(i)) {
                result = resultP.get(i);
            }
        }
        return result;
    }

    private void searchPath(TreeNode node,
                            TreeNode target,
                            LinkedList<TreeNode> path,
                            List<TreeNode> result,
                            boolean finish) {
        if (node == null || finish) {
            return;
        }
        path.add(node);
        if (node == target) {
            finish = true;
            result.addAll(path);
        }
        searchPath(node.left, target, path, result, finish);
        searchPath(node.right, target, path, result, finish);
        path.pollLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(1);

        TreeNode b1 = new TreeNode(6);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(0);
        TreeNode b4 = new TreeNode(8);

        TreeNode c1 = new TreeNode(7);
        TreeNode c2 = new TreeNode(8);

        root.left = a1;
        root.right = a2;
        a1.left = b1;
        a1.right = b2;
        a2.left = b3;
        a2.right = b4;
        b2.left = c1;
        b2.right = c2;

        Solution solution = new Solution();
        System.out.println(solution.lowestCommonAncestor(root, a1, a2));
        System.out.println(solution.lowestCommonAncestor(root, a1, c2));
    }
}
