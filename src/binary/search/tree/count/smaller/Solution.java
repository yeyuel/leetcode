package binary.search.tree.count.smaller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    class BSTNode {
        int val;
        int count = 0; // left children size
        BSTNode left = null;
        BSTNode right = null;
        BSTNode(int x) {
            this.val = x;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> count = new ArrayList<>();
        if (nums.length == 0) {
            return count;
        }
        count.add(0);
        if (nums.length < 2) {
            return count;
        }
        BSTNode root = new BSTNode(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >=0 ; i--) {
            count.add(bstInsert2(root, new BSTNode(nums[i])));
        }
        Collections.reverse(count);
        return count;
    }

    private int bstInsert2(BSTNode node, BSTNode insertNode)
    {
        int countSmall = 0;
        BSTNode cur = node;
        while (cur != insertNode)
        {
            if (insertNode.val <= cur.val)
            {
                if (cur.left == null)
                {
                    cur.left = insertNode;
                }
                cur.count++;
                cur = cur.left;
            }
            else
            {
                if (cur.right == null)
                {
                    cur.right = insertNode;
                }
                countSmall += cur.count + 1;
                cur = cur.right;
            }
        }
        return countSmall;
    }

    private int bstInsert(BSTNode node, BSTNode insertNode, Integer countSmall) {
        if (insertNode.val <= node.val) {
            node.count++;
            if (node.left != null) {
                return bstInsert(node.left, insertNode, countSmall);
            } else {
                node.left = insertNode;
                return countSmall;
            }
        } else {
            countSmall += node.count + 1;
            if (node.right != null) {
                return bstInsert(node.right, insertNode, countSmall);
            } else {
                node.right = insertNode;
                return countSmall;
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,2,6,6,1};
        System.out.println(solution.countSmaller(nums));
    }
}
