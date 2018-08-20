package divide.conquer.search.merge.k.sorted.list;

import linked.list.ListNode;
import linked.list.ListUtil;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }
        int mid = lists.length / 2;
        ListNode[] subList1 = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            subList1[i] = lists[i];
        }
        ListNode[] subList2 = new ListNode[lists.length - mid];
        int index = 0;
        for (int i = mid; i < lists.length; i++) {
            subList2[index++] = lists[i];
        }
        ListNode merged1 = mergeKLists(subList1);
        ListNode merged2 = mergeKLists(subList2);
        return mergeTwoLists(merged1, merged2);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode headNode = new ListNode(0);
        ListNode current = headNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        while (list1 != null) {
            current.next = list1;
            current = current.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            current.next = list2;
            current = current.next;
            list2 = list2.next;
        }
        return headNode.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);

        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(6);

        ListNode d1 = new ListNode(1);
        ListNode d2 = new ListNode(2);
        ListNode d3 = new ListNode(2);

        ListNode e1 = new ListNode(1);
        ListNode e2 = new ListNode(1);
        ListNode e3 = new ListNode(2);

        a1.next = a2; a2.next = a3;
        b1.next = b2; b2.next = b3;
        c1.next = c2;
        d1.next = d2; d2.next = d3;
        e1.next = e2; e2.next = e3;

        ListUtil.printList(a1);
        ListUtil.printList(b1);
        ListUtil.printList(c1);
        ListUtil.printList(d1);
        ListUtil.printList(e1);

        ListNode[] samples1 = new ListNode[]{a1, b1, c1};
        ListNode[] samples2 = new ListNode[]{d1, e1};
        Solution solution = new Solution();

//        ListUtil.printList(solution.mergeKLists(samples1));
        ListUtil.printList(solution.mergeKLists(samples2));
    }
}
