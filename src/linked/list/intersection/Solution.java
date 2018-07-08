package linked.list.intersection;

import linked.list.ListNode;
import linked.list.ListUtil;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = 0, bLength = 0;
        ListNode currentA = headA;
        ListNode currentB = headB;
        while (currentA != null) {
            aLength ++;
            currentA = currentA.next;
        }
        while (currentB != null) {
            bLength ++;
            currentB = currentB.next;
        }
        if (aLength > bLength) {
            int gap = aLength - bLength;
            while (headA != null && gap > 0) {
                headA = headA.next;
                gap --;
            }
        } else {
            int gap = bLength - aLength;
            while (headB != null && gap > 0) {
                headB = headB.next;
                gap --;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(11);
        ListNode a2 = new ListNode(12);
        ListNode b1 = new ListNode(21);
        ListNode b2 = new ListNode(22);
        ListNode b3 = new ListNode(23);
        ListNode c1 = new ListNode(31);
        ListNode c2 = new ListNode(32);
        ListNode c3 = new ListNode(33);

        a1.next = a2;
        a2.next = c1;
        b1.next = b2;
        b2.next = b3;
        a2.next = c1;
        b3.next = c1;
        c1.next = c2;
        c2.next = c3;

        ListUtil.printList(a1);
        ListUtil.printList(b1);

        Solution solution = new Solution();
        ListUtil.printList(solution.getIntersectionNode(a1, b1));
    }
}
