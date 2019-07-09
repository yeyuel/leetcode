/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package same.tree;

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
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        if (p == null && q == null)
        {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null))
        {
            return false;
        }
        if (p.val != q.val)
        {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args)
    {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        a1.left = a2;
        a1.right = a3;

        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(3);
        b1.left = b2;
        b1.right = b3;

        System.out.println(new Solution().isSameTree(a1, b1));
    }
}
