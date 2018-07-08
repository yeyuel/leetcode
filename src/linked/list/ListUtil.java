package linked.list;

public class ListUtil {

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.printf("[%d] ", head.val);
            head = head.next;
        }
        System.out.println();
    }
}
