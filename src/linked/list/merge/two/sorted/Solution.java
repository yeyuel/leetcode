package linked.list.merge.two.sorted;

import linked.list.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmpHead = new ListNode(0);
        ListNode pre = tmpHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }
        return tmpHead.next;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.printf("[%d] ", head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        a.next = b;
        b.next = c;

        ListNode d = new ListNode(1);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);
        d.next = e;
        e.next = f;

        Solution solution = new Solution();
        solution.printList(a);
        solution.printList(d);
        solution.printList(solution.mergeTwoLists(a, d));

    }
}
