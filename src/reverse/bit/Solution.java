package reverse.bit;

public class Solution {

    public int reverseBits1(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret = ret << 1;
            ret = n & 1 | ret;
            n = n >> 1;
        }
        return  ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseBits1(43261596));
        System.out.println(solution.reverseBits1(-3));
    }

}
