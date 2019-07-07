package binary.tree.inorder.traversal;

import binary.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalLoop(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode current, List<Integer> result) {
        if (current == null) {
            return;
        }
        inorderTraversal(current.left, result);
        result.add(current.val);
        inorderTraversal(current.right, result);
    }

    private void inorderTraversalLoop(TreeNode root, List<Integer> result) {
        Stack<TreeNode> treeStack = new Stack<>();
        TreeNode current = root;
        while (current != null || !treeStack.isEmpty()) {
            while (current != null) {
                treeStack.push(current);
                current = current.left;
            }
            current = treeStack.pop();
            result.add(current.val);
            current = current.right;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        root.right = a;
        a.left = b;
        System.out.println(new Solution().inorderTraversal(root));
    }
}
