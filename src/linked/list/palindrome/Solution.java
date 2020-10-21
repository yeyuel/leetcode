/*
 * Copyright (c) 2020 NeuLion, Inc. All Rights Reserved.
 */
package linked.list.palindrome;

import linked.list.ListNode;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2020/10/19$
 * @since 1.0
 */
public class Solution
{
    private ListNode frontPointer;

    public boolean isPalindrome1(ListNode head)
    {
        frontPointer = head;
        return recursiveCheck(head);
    }

    private boolean recursiveCheck(ListNode currentNode)
    {
        if (currentNode != null)
        {
            if (!recursiveCheck(currentNode.next)) return false;
            if (currentNode.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head)
    {
        if (head == null)
            return true;
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        ListNode p1 = head, p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null)
        {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfEnd.next = reverseList(secondHalfStart); // recover linked list
        return result;
    }

    private ListNode endOfFirstHalf(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head)
    {
        ListNode newHead = null;
        ListNode current = head;
        while (current != null)
        {
            ListNode next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;
        }
        return newHead;
    }

    public static void main(String[] args)
    {
        ListNode l1 = getLinkedList1();
        ListNode r1 = getLinkedList2();

        Solution solution = new Solution();
        System.out.println(solution.isPalindrome1(l1));
        System.out.println(solution.isPalindrome1(r1));

        l1 = getLinkedList1();
        r1 = getLinkedList2();
        System.out.println(solution.isPalindrome2(l1));
        System.out.println(solution.isPalindrome2(r1));
    }

    private static ListNode getLinkedList2()
    {
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(2);
        ListNode r3 = new ListNode(2);
        ListNode r4 = new ListNode(1);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        return r1;
    }

    private static ListNode getLinkedList1()
    {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        return l1;
    }
}
