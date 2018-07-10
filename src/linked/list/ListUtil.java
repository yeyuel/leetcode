package linked.list;

public class ListUtil {

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.printf("[%d] ", head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void printRandomList(RandomListNode head) {
        while (head != null) {
            RandomListNode randomPoint = head.random;
            if (randomPoint != null) {
                System.out.printf("[%d, %d] ", head.label, randomPoint.label);
            } else {
                System.out.printf("[%d, null] ", head.label);
            }
            head = head.next;
        }
        System.out.println();
    }
}
