package add.two.numbers;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyHead;
        int carry = 0;
        while (p != null || q != null)
        {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0)
        {
            current.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static ListNode buildList(int[] nums) {
        ListNode head = null;
        ListNode current = null;
        for (int num: nums) {
            if (head == null) {
                head = new ListNode(num);
                current = head;
            } else {
                current.next = new ListNode(num);
                current = current.next;
            }
        }
        return head;
    }

    public static ListNode buildReverseList(int[] nums) {
        ListNode tail = null;
        ListNode current;
        for (int num: nums) {
            current = new ListNode(num);
            current.next = tail;
            tail = current;
        }
        return tail;
    }


    public static void printListNode(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int[] num1 = new int[] {5};
        int[] num2 = new int[] {5};
        ListNode head = buildList(num1);
        printListNode(head);
        ListNode head1 = buildReverseList(num1);
        ListNode head2 = buildReverseList(num2);
        printListNode(head1);
        printListNode(head2);
        printListNode(new Solution().addTwoNumbers(head1, head2));
    }
}
