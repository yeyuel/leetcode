/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package linked.list.delete.given.node;

import linked.list.ListNode;
import linked.list.ListUtil;

import java.util.Arrays;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/21$
 * @since 1.0
 */
public class Solution
{
    public void deleteNode(ListNode node)
    {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private static ListNode makeList(int[] input)
    {
        ListNode[] nodes = new ListNode[input.length];
        for (int i = 0; i < input.length; i++)
        {
            nodes[i] = new ListNode(input[i]);
        }
        for (int i = 0; i < nodes.length - 1; i++)
        {
            nodes[i].next = nodes[i + 1];
        }
        return nodes[0];
    }

    private static ListNode getIthNode(ListNode head, int i)
    {
        while (i > 0 && head != null)
        {
            head = head.next;
            i--;
        }
        return head;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        ListNode head1 = makeList(new int[] { 4, 5, 1, 9 });
        ListNode target1 = getIthNode(head1, 1);
        solution.deleteNode(target1);
        ListUtil.printList(head1);

        ListNode head2 = makeList(new int[] { 4, 5, 1, 9 });
        ListNode target2 = getIthNode(head2, 2);
        solution.deleteNode(target2);
        ListUtil.printList(head2);
    }
}
