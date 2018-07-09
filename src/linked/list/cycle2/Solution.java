package linked.list.cycle2;

import linked.list.ListNode;


public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            if (fast == slow) {
                meet = fast;
                break;
            }
        }

        while (head != null && meet != null) {
            if (head == meet) {
                return head;
            }
            head = head.next;
            meet = meet.next;
        }
        return null;
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
        e.next = b;

        Solution solution = new Solution();
        System.out.println(solution.detectCycle(a).val);
    }
}
