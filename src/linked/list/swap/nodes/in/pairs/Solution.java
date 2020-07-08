/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package linked.list.swap.nodes.in.pairs;

import linked.list.ListNode;
import linked.list.ListUtil;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2019/11/6$
 * @since 1.0
 */
public class Solution
{
    public ListNode swapPairs(ListNode head)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre != null)
        {
            pre = reversePair(pre);
        }
        return dummy.next;
    }

    private ListNode reversePair(ListNode pre)
    {
        ListNode newTail = pre.next;
        if (newTail == null)
        {
            return null;
        }
        ListNode newHead = newTail.next;
        if (newHead == null)
        {
            return newTail;
        }
        newTail.next = newHead.next;
        pre.next = newHead;
        newHead.next = newTail;
        return newTail;
    }

    public ListNode swapPairs2(ListNode head)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preTail = dummy;
        while (true)
        {
            ListNode twoStep = preTail;
            for (int k = 0; k < 2 && twoStep != null; k ++)
            {
                twoStep = twoStep.next;
            }
            if (twoStep == null)
            {
                break;
            }
            ListNode next = twoStep.next;
            preTail = reverseTwo(preTail);
            preTail.next = next;
        }
        return dummy.next;
    }

    private ListNode reverseTwo(ListNode preTail)
    {
        ListNode newTail = preTail.next;
        ListNode newHead = preTail.next.next;
        preTail.next = newHead;
        newHead.next = newTail;
        return newTail;
    }

    public static void main(String[] args)
    {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;

        ListUtil.printList(one);
        Solution solution = new Solution();
        one = solution.swapPairs2(one);
        ListUtil.printList(one);
    }
}
