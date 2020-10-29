package k.th.smallest.bst;

import binary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int kthSmallest1(TreeNode root, int k) {
        List<Integer> nums = inorder(root, new ArrayList<>());
        return nums.get(k - 1);
    }

    public int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

    private List<Integer> inorder(TreeNode root, List<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public static TreeNode buildBst(int[] values) {
        TreeNode root = new TreeNode(values[0]);
        for (int i = 1; i < values.length; i++) {
            TreeNode cur = root;
            TreeNode newNode = new TreeNode(values[i]);
            while (cur != newNode) {
                if (newNode.val < cur.val) {
                    if (cur.left == null) {
                        cur.left = newNode;
                    }
                    cur = cur.left;
                } else {
                    if (cur.right == null) {
                        cur.right = newNode;
                    }
                    cur = cur.right;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{3, 1, 4, 2};
        int[] input2 = new int[]{5, 3, 6, 2, 4, 1};
        TreeNode root1 = buildBst(input1);
        TreeNode root2 = buildBst(input2);

        Solution solution = new Solution();
        System.out.println(solution.kthSmallest1(root1, 1));
        System.out.println(solution.kthSmallest1(root2, 3));

        System.out.println(solution.kthSmallest2(root1, 1));
        System.out.println(solution.kthSmallest2(root2, 3));
    }
}
