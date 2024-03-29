package slide.window.k.different.subarray;

import java.util.Arrays;

public class Solution {

    public int subarraysWithKDistinctNew(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] hash = new int[A.length + 1];
        int l = 0, r = 0, valid = 0, results = 0;
        while (r < A.length) {
            int c = A[r];
            if (++hash[c] == 1) valid ++;

            while (valid >= K) {
                int d = A[l];
                if (valid == K) {
                    results++;
                }
                l ++;

                if (hash[d] > 0) {
                    if (--hash[d] == 0) {
                        valid--;
                    }
                }
            }
            r++;
        }
        return results;
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] hash = new int[A.length + 1];

        int l = 0, results = 0, count = 0, result = 1;
        for (int r = 0; r < A.length; r++) {
            hash[A[r]]++;

            if (hash[A[r]] == 1) {
                count ++;
            }

            while (hash[A[l]] > 1 || count > K) {
                if (count > K) {
                    result = 1;
                    count--;
                } else {
                    result ++;
                }
                hash[A[l]]--;
                l ++;
            }

            if (count == K) {
                results += result;
            }
        }
        return  results;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 1, 3, 4};
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.subarraysWithKDistinctNew(a, k));
    }
}
