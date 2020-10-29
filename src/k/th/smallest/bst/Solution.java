/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package k.th.smallest.bst;

import binary.TreeNode;

import java.util.Deque;
import java.util.LinkedList;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/29$
 * @since 1.0
 */
public class Solution
{
    public int kthSmallest(TreeNode root, int k)
    {
        Deque<TreeNode> stack = new LinkedList<>();
        while (true)
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0)
                break;
            root = root.right;
        }
        return root.val;
    }

    public static TreeNode buildBst(int[] values)
    {
        TreeNode root = new TreeNode(values[0]);
        for (int i = 1; i < values.length; i++)
        {
            TreeNode newNode = new TreeNode(values[i]);
            TreeNode cur = root;
            while (cur != newNode)
            {
                if (newNode.val < cur.val)
                {
                    if (cur.left == null)
                    {
                        cur.left = newNode;
                    }
                    cur = cur.left;
                }
                else
                {
                    if (cur.right == null)
                    {
                        cur.right = newNode;
                    }
                    cur = cur.right;
                }
            }
        }
        return root;
    }

    public static void main(String[] args)
    {
        int[] input1 = new int[] { 3, 1, 4, 2 };
        int[] input2 = new int[] { 5, 3, 6, 2, 4, 1 };
        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(buildBst(input1), 1));
        System.out.println(solution.kthSmallest(buildBst(input2), 3));
    }
}
