package atoi;

public class Solution {

    // TODO refactor logic
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        int ret = 0;
        int positive = 1;
        char first = ' ';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (first != ' ' && c == ' ' && i < str.length() - 1) {
                char next = str.charAt(i + 1);
                if (next >= '0' && next <= '9') {
                    break;
                }
            }
            if (' ' == c) {
                continue;
            }
            if (first == ' ') {
                first = c;
            } else {
                if  (c < '0' || c > '9'){
                    break;
                }
            }
            if (first == '-') {
                positive = -1;
            }
            if (c >= '0' && c <= '9') {
                if ((first < '0' || first > '9') && first != '-' && first != '+') {
                    break;
                }
                int val = c - '0';
                if ((Integer.MAX_VALUE - val) / 10 < ret && positive > 0) {
                    ret = Integer.MAX_VALUE;
                    break;
                }
                if ((Integer.MIN_VALUE + val) / 10 > -ret && positive < 0) {
                    ret = Integer.MIN_VALUE;
                    positive = 1;
                    break;
                }
                ret = ret * 10 + val;
            }
        }
        return positive * ret;
    }

    public static void main(String[] args) {
        String test1 = "42";
        String test2 = "   -42";
        String test3 = "4193 with words";
        String test4 = "words and 987";
        String test5 = "-91283472332";
        String test6 = "+-2";
        String test7 = ".1";
        String test8 = "+1";
        String test9 = "   +0 123";
        String test10 = "    -88827   5655  U";
        Solution solution = new Solution();
        System.out.println(solution.myAtoi(test1));
        System.out.println(solution.myAtoi(test2));
        System.out.println(solution.myAtoi(test3));
        System.out.println(solution.myAtoi(test4));
        System.out.println(solution.myAtoi(test5));
        System.out.println(solution.myAtoi(test6));
        System.out.println(solution.myAtoi(test7));
        System.out.println(solution.myAtoi(test8));
        System.out.println(solution.myAtoi(test9));
        System.out.println(solution.myAtoi(test10));
    }
}
