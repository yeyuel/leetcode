package max.path.sum.bt;

import binary.TreeNode;

public class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int priceNewPath = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, priceNewPath);
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        root1.left = left1;
        root1.right = right1;

        TreeNode root2 = new TreeNode(-10);
        TreeNode left2 = new TreeNode(9);
        TreeNode right2 = new TreeNode(20);
        TreeNode ll2 = new TreeNode(15);
        TreeNode lr2 = new TreeNode(7);
        root2.left = left2;
        root2.right = right2;
        right2.left = ll2;
        right2.right = lr2;

        Solution solution = new Solution();
        System.out.println(solution.maxPathSum(root1));
        System.out.println(solution.maxPathSum(root2));
    }
}
