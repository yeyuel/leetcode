package is.power.of.three;

public class Solution {

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfThree(27));
        System.out.println(solution.isPowerOfThree(0));
        System.out.println(solution.isPowerOfThree(9));
        System.out.println(solution.isPowerOfThree(45));
    }
}
