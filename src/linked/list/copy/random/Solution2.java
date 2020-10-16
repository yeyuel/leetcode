/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package linked.list.copy.random;

import linked.list.ListUtil;
import linked.list.RandomListNode;

import java.util.HashMap;
import java.util.Map;


/**
 * Solution2.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/16$
 * @since 1.0
 */
public class Solution2
{
    private Map<RandomListNode, RandomListNode> visited = new HashMap<>();

    public RandomListNode getCloneNode(RandomListNode node)
    {
        if (node != null)
        {
            if (!this.visited.containsKey(node))
            {
                this.visited.put(node, new RandomListNode(node.label));
            }
            return this.visited.get(node);
        }
        return null;
    }

    public RandomListNode copyRandomList(RandomListNode head)
    {
        if (head == null)
            return null;
        RandomListNode oldNode = head;
        RandomListNode newNode = new RandomListNode(oldNode.label);
        this.visited.put(oldNode, newNode);
        while (oldNode != null)
        {
            newNode.random = this.getCloneNode(oldNode.random);
            newNode.next = this.getCloneNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
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

        Solution2 solution = new Solution2();
        RandomListNode copy = solution.copyRandomList(a);
        a.next = null;
        ListUtil.printRandomList(copy);
    }
}
