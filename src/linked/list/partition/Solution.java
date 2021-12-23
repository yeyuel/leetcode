package linked.list.partition;

import linked.list.ListNode;
import linked.list.ListUtil;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode moreHead = new ListNode(0);
        ListNode lessPoint = lessHead;
        ListNode morePoint = moreHead;
        while (head != null ) {
            if (head.val < x) {
                lessPoint.next = head;
                lessPoint = lessPoint.next;
            } else {
                morePoint.next = head;
                morePoint = morePoint.next;
            }
            head = head.next;
        }
        lessPoint.next = moreHead.next;
        morePoint.next = null;
        return lessHead.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(2);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        ListUtil.printList(a);

        Solution solution = new Solution();
        ListNode partitioned = solution.partition(a, 3);

        ListUtil.printList(partitioned);
    }
}
