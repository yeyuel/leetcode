/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package linked.list.odd.even.list;

import linked.list.ListNode;
import linked.list.ListUtil;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/21$
 * @since 1.0
 */
public class Solution
{
    public ListNode oddEvenList(ListNode head)
    {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null)
        {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args)
    {
        ListNode l1 = ListUtil.makeList(new int[] { 1, 2, 3, 4, 5 });
        ListNode l2 = ListUtil.makeList(new int[] { 2, 1, 3, 5, 6, 4, 7 });

        Solution solution = new Solution();
        l1 = solution.oddEvenList(l1);
        l2 = solution.oddEvenList(l2);

        ListUtil.printList(l1);
        ListUtil.printList(l2);
    }
}
