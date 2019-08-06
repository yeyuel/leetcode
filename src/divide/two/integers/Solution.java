package divide.two.integers;

public class Solution {

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return -1;
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative = (dividend ^ divisor) < 0;
        int res = 0, divCount = 1;

        long dividendTmp = Math.abs((long) dividend);
        long divisorTmp = Math.abs((long) divisor);

        while (dividendTmp >= divisorTmp) {
            dividendTmp -= divisorTmp;
            res += divCount;

            if (dividendTmp < Math.abs(divisor)) {
                break;
            }

            if (dividendTmp - divisorTmp < divisorTmp) {
                divisorTmp = Math.abs(divisor);
                divCount = 1;
                continue;
            }

            divisorTmp += divisorTmp;
            divCount += divCount;
        }
        return negative ? 0 - res: res;
    }

    public int divide1(int dividend, int divisor) {
        int sign = (dividend ^ divisor) >> 31;
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        long res = 0;
        while (lDividend >= lDivisor) {
            long tmp = lDivisor;
            long i = 1;
            while (lDividend >= tmp) {
                lDividend -= tmp;
                res += i;
                i <<= 1;
                tmp <<= 1;
            }
        }
        if (sign == -1) res = -res;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(10, 3));
        System.out.println(solution.divide(7, -3));
        System.out.println(solution.divide1(10, 3));
        System.out.println(solution.divide1(7, -3));
    }
}
