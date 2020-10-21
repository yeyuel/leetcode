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

    public static ListNode makeList(int[] input)
    {
        ListNode[] nodes = new ListNode[input.length];
        for (int i = 0; i < input.length; i++)
        {
            nodes[i] = new ListNode(input[i]);
        }
        for (int i = 0; i < nodes.length - 1; i++)
        {
            nodes[i].next = nodes[i + 1];
        }
        return nodes[0];
    }
}
