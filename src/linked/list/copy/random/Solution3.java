/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package linked.list.copy.random;

import linked.list.ListUtil;
import linked.list.RandomListNode;


/**
 * Solution3. 138
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/16$
 * @since 1.0
 */
public class Solution3
{
    public RandomListNode copyRandomList(RandomListNode head)
    {
        if (head == null)
            return null;
        RandomListNode ptr = head;
        while (ptr != null)
        {
            RandomListNode newNode = new RandomListNode(ptr.label);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }
        ptr = head;
        while (ptr != null)
        {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }
        RandomListNode ptrOldList = head;
        RandomListNode ptrNewList = head.next;
        RandomListNode headNew = head.next;
        while (ptrOldList != null)
        {
            ptrOldList.next = ptrOldList.next.next;
            ptrNewList.next = (ptrNewList.next != null) ? ptrNewList.next.next : null;
            ptrOldList = ptrOldList.next;
            ptrNewList = ptrNewList.next;
        }
        return headNew;
    }

    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        RandomListNode e = new RandomListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        a.random = c;
        b.random = null;
        c.random = b;
        d.random = a;

        ListUtil.printRandomList(a);

        Solution3 solution = new Solution3();
        RandomListNode copy = solution.copyRandomList(a);
        a.next = null;
        ListUtil.printRandomList(copy);
    }
}
