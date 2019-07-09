/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package symmetric.tree;

import binary.TreeNode;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2019/7/9$
 * @since 1.0
 */
public class Solution
{
    public boolean isSymmetric(TreeNode root)
    {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2)
    {
        if (t1 == null && t2 == null)
        {
            return true;
        }
        if (t1 == null || t2 == null)
        {
            return false;
        }
        return t1.val == t2.val
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(3);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        solution.isSymmetric(a);
    }
}
