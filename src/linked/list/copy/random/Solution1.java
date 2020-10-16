/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package linked.list.copy.random;

import linked.list.ListUtil;
import linked.list.RandomListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Solution1.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/16$
 * @since 1.0
 */
public class Solution1
{
    Map<RandomListNode, RandomListNode> visitedHash = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head)
    {
        if (head == null)
            return null;

        if (this.visitedHash.containsKey(head))
        {
            return this.visitedHash.get(head);
        }

        RandomListNode node = new RandomListNode(head.label);
        this.visitedHash.put(head, node);
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
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

        Solution1 solution = new Solution1();
        RandomListNode copy = solution.copyRandomList(a);
        a.next = null;
        ListUtil.printRandomList(copy);
    }
}
