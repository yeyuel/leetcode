package binary.search.tree.sorted.array.to.bst;

import binary.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        List<TreeNode> nodeVec = new ArrayList<>();
        preorderInsert(nums, nodeVec, 0, nums.length - 1);
        System.out.println(nodeVec);
        for (TreeNode node: nodeVec) {
            bstInsert(nodeVec.get(0), node);
        }
        return nodeVec.get(0);
    }

    private void bstInsert(TreeNode node, TreeNode insertNode) {
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

    private void preorderInsert(int[] nums,
                                List<TreeNode> nodeVec,
                                int begin,
                                int end) {
        if (begin > end) {
            return;
        }
        int mid = (begin + end) / 2;
        nodeVec.add(new TreeNode(nums[mid]));
        preorderInsert(nums, nodeVec, begin, mid - 1);
        preorderInsert(nums, nodeVec, mid + 1, end);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sample = {-10,-3,0,5,9};
        solution.sortedArrayToBST(sample);
    }
}
