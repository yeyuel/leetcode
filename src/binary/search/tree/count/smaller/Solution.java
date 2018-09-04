package binary.search.tree.count.smaller;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    class BSTNode {
        int val;
        int count = 0;
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
        BSTNode[] nodeVec = new BSTNode[nums.length];
        for (int i = nums.length - 1; i >= 0 ; i--) {
            nodeVec[i] = new BSTNode(nums[i]);
        }
        count.add(0);
        for (int i = 1; i < nodeVec.length; i++) {
            int countSmall = 0;
            countSmall = bstInsert(nodeVec[0], nodeVec[i], countSmall);
            count.add(countSmall);
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = count.size() - 1; i >=0 ; i--) {
            ret.add(count.get(i));
        }
        return ret;
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
        int[] nums = {5,2,6,1};
        System.out.println(solution.countSmaller(nums));
    }
}
