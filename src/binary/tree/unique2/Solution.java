package binary.tree.unique2;

import binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<TreeNode> generateTrees(int n) {
        return generateSubTree(1, n + 1);
    }

    private List<TreeNode> generateSubTree(int l, int r) {
        List<TreeNode> subTree = new ArrayList<>();

        if (l >= r) {
            subTree.add(null);
            return subTree;
        }
        if (l == r - 1) {
            subTree.add(new TreeNode(l));
            return subTree;
        }
        for (int i = 1; i < r; i++) {
            List<TreeNode> leftSubTree = generateSubTree(l, i);
            List<TreeNode> rightSubTree = generateSubTree(i + 1, r);

            for (int j = 1; j < leftSubTree.size(); j++) {
                for (int k = 0; k < rightSubTree.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubTree.get(l);
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
