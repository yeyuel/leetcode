/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package linked.list.sort;

import linked.list.ListNode;
import linked.list.ListUtil;

import java.util.List;
import java.util.logging.Level;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/19$
 * @since 1.0
 */
public class Solution
{
    public ListNode sortList1(ListNode head)
    {
        if (head == null || head.next == null)
            return head;
        ListNode fast =  head.next, slow = head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList1(head);
        ListNode right = sortList1(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null)
        {
            if (left.val < right.val)
            {
                h.next = left;
                left = left.next;
            }
            else
            {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    public ListNode sortList2(ListNode head)
    {
        int length = getLength(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for (int step = 1; step < length; step *= 2)
        {
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            while (cur != null)
            {
                ListNode h1 = cur;
                ListNode h2 = split(h1, step);
                cur = split(h2, step); // head of left parts
                ListNode tmp = merge(h1, h2);
                pre.next = tmp;
                while (pre.next != null)
                {
                    pre = pre.next;
                }
            }
        }
        return dummy.next;
    }

    public int getLength(ListNode head)
    {
        int count = 0;
        while (head != null)
        {
            count++;
            head = head.next;
        }
        return count;
    }

    public ListNode split(ListNode head, int step)
    {
        if (head == null) return null;
        ListNode cur = head;
        for (int i = 1; i < step && cur.next != null; i++)
        {
            cur = cur.next;
        }
        ListNode right = cur.next;
        cur.next = null;
        return right;
    }

    public ListNode merge(ListNode h1, ListNode h2)
    {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (h1 != null && h2 != null)
        {
            if (h1.val < h2.val)
            {
                p.next = h1;
                h1 = h1.next;
            }
            else
            {
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        if (h1 != null) p.next = h1;
        if (h2 != null) p.next = h2;
        return head.next;
    }


    public static void main(String[] args)
    {
        Solution solution = new Solution();
        ListNode l1 = getListNode1();
        ListNode newL1 = solution.sortList1(l1);
        ListUtil.printList(newL1);

        ListNode r1 = getListNode2();
        ListNode newR1 = solution.sortList1(r1);
        ListUtil.printList(newR1);

        l1 = getListNode1();
        newL1 = solution.sortList2(l1);
        ListUtil.printList(newL1);

        r1 = getListNode2();
        newR1 = solution.sortList2(r1);
        ListUtil.printList(newR1);
    }

    private static ListNode getListNode2()
    {
        ListNode r1 = new ListNode(-1);
        ListNode r2 = new ListNode(5);
        ListNode r3 = new ListNode(3);
        ListNode r4 = new ListNode(4);
        ListNode r5 = new ListNode(0);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;
        return r1;
    }

    private static ListNode getListNode1()
    {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        return l1;
    }
}
