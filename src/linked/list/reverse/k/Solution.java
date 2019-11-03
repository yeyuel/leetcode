package linked.list.reverse.k;

import linked.list.ListNode;
import linked.list.ListUtil;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        while (true) {
            ListNode kStep = start;
            for (int i = 0; i < k && kStep != null; i++) {
                kStep = kStep.next;
            }
            if (kStep == null) {
                break;
            }
            ListNode next = kStep.next;
            start = reverseAmong(start, k);
            start.next = next;
        }
        return dummy.next;
    }

    private ListNode reverseAmong(ListNode preTail, int k) {
        ListNode current = preTail.next, newTail = preTail.next;
        ListNode newHead = null;
        int count = k;
        while (count > 0) {
            count --;
            ListNode next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;

        }
        preTail.next = newHead;
        return newTail;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListUtil.printList(l1);
        Solution solution = new Solution();
        ListNode newHead = solution.reverseKGroup(l1, 3);
        ListUtil.printList(newHead);
    }
}
