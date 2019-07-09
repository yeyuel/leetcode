package binary.tree.unique2;

import binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        return generateSubTree(1, n);
    }

    private List<TreeNode> generateSubTree(int start, int end) {
        List<TreeNode> subTree = new ArrayList<>();

        if (start > end) {
            subTree.add(null);
            return subTree;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTree = generateSubTree(start, i - 1);
            List<TreeNode> rightSubTree = generateSubTree(i + 1, end);

            for (int j = 0; j < leftSubTree.size(); j++) {
                for (int k = 0; k < rightSubTree.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubTree.get(j);
                    root.right = rightSubTree.get(k);
                    subTree.add(root);
                }
            }
        }
        return subTree;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateTrees(3));
    }
}
