package four.sum.two;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> cache = new HashMap<>();
        int count = 0;
        for (int a : A) {
            for (int b : B) {
                cache.put(a + b, cache.getOrDefault(a + b, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                count += cache.getOrDefault(-c - d, 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        System.out.println(new Solution().fourSumCount(A, B, C, D));
    }
}
