/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package validate.binary.search.tree;

import binary.TreeNode;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Stack;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2019/7/9$
 * @since 1.0
 */
public class Solution
{
    public boolean isValidBst(TreeNode root)
    {
        return helper(root, null, null);
    }

    public boolean isValidBST(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null)
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder)
            {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    private boolean helper(TreeNode node, Integer lower,
            Integer upper)
    {
        if (node == null)
        {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower)
        {
            return false;
        }
        if (upper != null && val >= upper)
        {
            return false;
        }
        if (!helper(node.right, val, upper))
        {
            return false;
        }
        if (!helper(node.left, lower, val))
        {
            return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();

        TreeNode a1 = new TreeNode(2);
        TreeNode b1 = new TreeNode(1);
        TreeNode c1 = new TreeNode(3);
        a1.left = b1;
        a1.right = c1;
        System.out.println(solution.isValidBST(a1));

        TreeNode a2 = new TreeNode(5);
        TreeNode b2 = new TreeNode(1);
        TreeNode c2 = new TreeNode(4);
        TreeNode d2 = new TreeNode(3);
        TreeNode e2 = new TreeNode(6);
        a2.left = b2;
        a2.right = c2;
        c2.left = d2;
        c2.right = e2;
        System.out.println(solution.isValidBST(a2));
    }
}
