package add.two.numbers;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode resultHead = null;
        ListNode current = null;
        boolean carry = false;
        while (current1 != null ||  current2 != null) {
            int position;
            if (current1 != null && current2 != null) {
                position = current1.val + current2.val;
            } else if(current1 != null){
                position = current1.val;
            } else {
                position = current2.val;
            }
            if (carry) {
                position += 1;
            }
            if (position >= 10) {
                position -= 10;
                carry = true;
            } else {
                carry = false;
            }
            if (resultHead == null) {
                resultHead = new ListNode(position);
                current = resultHead;
            } else {
                current.next = new ListNode(position);
                current = current.next;
            }
            if (current1 != null) {
                current1 = current1.next;
            }
            if (current2 != null) {
                current2 = current2.next;
            }
        }
        if (carry) {
            current.next = new ListNode(1);
        }
        return resultHead;
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
