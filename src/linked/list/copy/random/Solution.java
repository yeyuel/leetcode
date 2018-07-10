package linked.list.copy.random;

import linked.list.ListUtil;
import linked.list.RandomListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, Integer> originMap = new HashMap<>();
        List<RandomListNode> targetList = new ArrayList<>();
        RandomListNode point = head;
        int i = 0;
        while (point != null) {
            originMap.put(point, i);
            targetList.add(new RandomListNode(point.label));
            point = point.next;
            i ++;
        }
        targetList.add(null);

        point = head;
        i = 0;
        while (point != null) {
            targetList.get(i).next = targetList.get(i + 1);
            if (point.random != null) {
                int id = originMap.get(point.random);
                targetList.get(i).random = targetList.get(id);
            }
            point = point.next;
            i ++;
        }
        return targetList.get(0);
    }

    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        RandomListNode e = new RandomListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        a.random = c;
        b.random = null;
        c.random = b;
        d.random = a;

        ListUtil.printRandomList(a);

        Solution solution = new Solution();
        RandomListNode copy = solution.copyRandomList(a);
        a.next = null;
        ListUtil.printRandomList(copy);
    }
}
