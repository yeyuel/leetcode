package binary.tree.right.side.view;

import binary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    class Tuple {
        public TreeNode key;
        public int val;
        public Tuple(TreeNode key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root != null) queue.addLast(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.peek();
                if (i == queueSize - 1) view.add(node.val);
                queue.pop();
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
        }
        return view;
    }


    public List<Integer> rightSideViewOld(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        LinkedList<Tuple> queue = new LinkedList<>();

        if (root != null) {
            queue.push(new Tuple(root, 0));
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.peek().key;
            int depth = queue.peek().val;
            queue.pop();

            if (view.size() == depth) {
                view.add(node.val);
            } else {
                view.set(depth, node.val);
            }
            if (node.left != null) {
                queue.add(new Tuple(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.add(new Tuple(node.right, depth + 1));
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
