package binary.tree.zigzag.order.traversal;

import binary.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        LinkedList<LevelTreeNode> queue = new LinkedList<>();
        queue.add(new LevelTreeNode(root, 1));
        while (!queue.isEmpty()) {
            LevelTreeNode lNode = queue.poll();
            int level = lNode.getLevel();
            TreeNode node = lNode.getNode();
            boolean last = lNode.isLast();

            if (level > ret.size()) {
                if (level != 1 && !queue.isEmpty()) {
                    queue.peekLast().setLast(true);
                }
                ret.add(new ArrayList<>());
            }

            ret.get(level - 1).add(node.val);

            if (last && level % 2 == 0) {
                Collections.reverse(ret.get(level - 1));
            }

            if (node.left != null) {
                queue.add(new LevelTreeNode(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new LevelTreeNode(node.right, level + 1));
            }
        }
        return ret;
    }

    class LevelTreeNode
    {
        TreeNode node;
        int level;
        boolean last;

        public LevelTreeNode(TreeNode node, int level)
        {
            this.node = node;
            this.level = level;
        }

        public TreeNode getNode()
        {
            return node;
        }

        public int getLevel()
        {
            return level;
        }

        public boolean isLast() {
            return last;
        }

        public void setLast(boolean last) {
            this.last = last;
        }
    }

    public static void main(String[] args)
    {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        a1.left = a2;

        Solution solution = new Solution();
        System.out.println(solution.zigzagLevelOrder(a));
        System.out.println(solution.zigzagLevelOrder(a1));
    }

}
