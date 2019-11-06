/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package linked.list.remove.n.from.end;

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
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++)
        {
            fast = fast.next;
        }
        if (fast == null)
        {
            return slow.next;
        }
        while (fast.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args)
    {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListUtil.printList(one);
        Solution solution = new Solution();
        one = solution.removeNthFromEnd(one, 1);
        ListUtil.printList(one);
    }
}
