package count.primes;

public class Solution {
    public int countPrimes1(int n) {
        int count = 0;
        boolean[] signs = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!signs[i]) {
                count ++;
                for (int j = i + 1; j < n; j+= i) {
                    signs[j] = true;
                }
            }
        }
        return count;
    }

    public int countPrimes2(int n) {
        int count = 0;
        int[] signs = new int[n / 32 + 1];
        for (int i = 2; i < n; i++) {
            if ((signs[i / 32] & (1 << (i & 31))) == 0) {
                count ++;
                for (int j = i + 1; j < n; j += i) {
                    signs[j / 32] = 1 << (j & 31);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes1(10));
        System.out.println(solution.countPrimes1(0));
        System.out.println(solution.countPrimes1(1));
        System.out.println(solution.countPrimes1(4));

        System.out.println(solution.countPrimes2(10));
        System.out.println(solution.countPrimes2(0));
        System.out.println(solution.countPrimes2(1));
    }
}
