package binary.tree.path.sum.two;

import binary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        searchSum(root, result, path, 0, sum);
        return result;
    }

    private void searchSum(TreeNode root,
                           List<List<Integer>> result,
                           LinkedList<Integer> path,
                           int current,
                           int sum) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        current += root.val;

        // is leaf
        if (root.left == null && root.right == null &&
            sum == current) {
            result.add((LinkedList) path.clone());
        }

        searchSum(root.left, result, path, current, sum);
        searchSum(root.right, result, path, current, sum);

        path.pollLast();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        TreeNode a1 = new TreeNode(4);
        TreeNode a2 = new TreeNode(8);
        TreeNode b1 = new TreeNode(11);
        TreeNode b2 = new TreeNode(13);
        TreeNode b3 = new TreeNode(4);
        TreeNode c1 = new TreeNode(7);
        TreeNode c2 = new TreeNode(2);
        TreeNode c3 = new TreeNode(5);
        TreeNode c4 = new TreeNode(1);

        root.left = a1; root.right = a2;
        a1.left = b1; a2.left = b2; a2.right = b3;
        b1.left = c1; b1.right = c2; b3.left = c3; b3.right = c4;

        System.out.println(solution.pathSum(root, 22));
    }
}
