package linked.list.reverse;

import linked.list.ListNode;

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
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
        head = solution.reverseList(head);
        while (head != null) {
            System.out.printf("[%d] ", head.val);
            head = head.next;
        }
    }

}
