package linked.list.reverse2;

import linked.list.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int changLength = n- m + 1;
        ListNode preHead = null;
        ListNode result = head;
        while (head != null && --m > 0) {
            preHead = head;
            head = head.next;
        }
        ListNode lastModifiredTail = head;

        // reverse logic
        ListNode newHead = null;
        while (head != null && changLength > 0) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            changLength --;
        }

        // connect tail
        lastModifiredTail.next = head;

        // connect head
        if (preHead != null) {
            preHead.next = newHead;
        } else {
            result = newHead;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode head = a;
        while (head != null) {
            System.out.printf("[%d] ", head.val);
            head = head.next;
        }

        System.out.println();
        head = a;
        Solution solution = new Solution();
        head = solution.reverseBetween(head, 2, 4);
        while (head != null) {
            System.out.printf("[%d] ", head.val);
            head = head.next;
        }
    }
}
