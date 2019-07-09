/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package binary.tree.level.order.traversal;

import binary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2019/7/9$
 * @since 1.0
 */
public class Solution
{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)
        {
            return ret;
        }
        ret.add(new ArrayList<>());
        LinkedList<LevelTreeNode> queue = new LinkedList<>();
        int currentLevel = 1;
        queue.add(new LevelTreeNode(root, currentLevel));
        while (!queue.isEmpty())
        {
            LevelTreeNode lNode = queue.poll();
            TreeNode node = lNode.getNode();
            int level = lNode.getLevel();
            if (level > currentLevel)
            {
                if (ret.size() < level)
                {
                    ret.add(new ArrayList<>());
                }
                currentLevel ++;
            }
            ret.get(level - 1).add(node.val);
            if (node.left != null)
            {
                queue.add(new LevelTreeNode(node.left, level + 1));
            }
            if (node.right != null)
            {
                queue.add(new LevelTreeNode(node.right, level + 1));
            }
        }
        return ret;
    }

    class LevelTreeNode
    {
        TreeNode node;
        int level;

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

        Solution solution = new Solution();
        System.out.println(solution.levelOrder(a));
    }
}
