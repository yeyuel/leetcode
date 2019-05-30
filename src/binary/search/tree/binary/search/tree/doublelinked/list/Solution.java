/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package binary.search.tree.binary.search.tree.doublelinked.list;

/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2019/5/30$
 * @since 1.0
 */
public class Solution
{
    public TreeNode toDoubleLinkedList(TreeNode head)
    {
        return inorderTraverse(head, null);
    }

    private TreeNode inorderTraverse(TreeNode node, TreeNode lastNode)
    {
        if (node == null)
        {
            return lastNode;
        }
        if (node.left != null)
        {
            lastNode = inorderTraverse(node.left, lastNode);
        }
        node.left = lastNode;
        if (lastNode != null)
        {
            lastNode.right = node;
        }
        lastNode = node;
        if (node.right != null)
        {
            lastNode = inorderTraverse(node.right, lastNode);
        }
        return lastNode;
    }

    public TreeNode buildBst(int[] values)
    {
        if (values.length < 1)
        {
            return null;
        }
        TreeNode head = new TreeNode(values[0]);
        if (values.length == 1)
        {
            return head;
        }
        for (int i = 1; i < values.length; i++)
        {
            TreeNode ptr = head;
            TreeNode newNode = new TreeNode(values[i]);
            while (ptr != newNode)
            {
                if (newNode.val < ptr.val)
                {
                    if (ptr.left == null)
                    {
                        ptr.left = newNode;
                    }
                    ptr = ptr.left;
                }
                else
                {
                    if (ptr.right == null)
                    {
                        ptr.right = newNode;
                    }
                    ptr = ptr.right;
                }
            }
        }
        return head;
    }

    public void inorderPrint(TreeNode head, int layer)
    {
        if (head == null)
        {
            return;
        }
        inorderPrint(head.left, layer + 1);
        for (int i = 0; i < layer; i++)
        {
            System.out.print("---");
        }
        System.out.println(head.val);
        inorderPrint(head.right, layer + 1);
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        TreeNode head = solution.buildBst(new int[] { 4, 3, 5, 2, 6, 1, 7, 0 });
        solution.inorderPrint(head, 0);
        TreeNode last = solution.toDoubleLinkedList(head);
        while (last != null)
        {
            System.out.print(last.val);
            if (last.left != null)
            {
                System.out.print(" <- ");
            }
            last = last.left;
        }
        System.out.println();
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val)
    {
        this.val = val;
    }
}
