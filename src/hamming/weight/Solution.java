package hamming.weight;

public class Solution {

    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(11));
        System.out.println(solution.hammingWeight((int) Math.pow(2, 7)));
        System.out.println(solution.hammingWeight(Integer.MIN_VALUE - 2));
    }
}
