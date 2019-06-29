package slide.window.k.different.subarray;

public class Solution {

    public int subArraysWithKDistinct(int[] A, int k) {
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

            while (hash[A[l]] > 1 || count > k) {
                if (count > k) {
                    result = 1;
                    count--;
                } else {
                    result ++;
                }
                hash[A[l]]--;
                l ++;
            }

            if (count == k) {
                results += result;
            }
        }
        return  results;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 1, 3, 4};
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.subArraysWithKDistinct(a, k));
    }
}
