package binary.tree.right.side.view;

import binary.TreeNode;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        LinkedList<AbstractMap.SimpleEntry<TreeNode, Integer>> queue = new LinkedList<>();

        if (root != null) {
            queue.push(new AbstractMap.SimpleEntry<>(root, 0));
        }

        while (!queue.isEmpty()) {
             TreeNode node = queue.peek().getKey();
            int depth = queue.peek().getValue();
            queue.pop();

            if (view.size() == depth) {
                view.add(node.val);
            } else {
                view.set(depth, node.val);
            }
            if (node.left != null) {
                queue.add(new AbstractMap.SimpleEntry<>(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.add(new AbstractMap.SimpleEntry<>(node.right, depth + 1));
            }
        }
        return view;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(6);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        Solution solution = new Solution();
        System.out.println(solution.rightSideView(a));
    }
}
