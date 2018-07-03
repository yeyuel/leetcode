package regular.expression;

public class Solution1 {

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean firstMatch = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) ||
                    (firstMatch && isMatch(text.substring(1), pattern)));
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        String s1 = "aa"; String p1 = "a";
        String s2 = "aa"; String p2 = "a*";
        String s3 = "ab"; String p3 = ".*";
        String s4 = "aab"; String p4 = "c*a*b";
        String s5 = "mississippi"; String p5 = "mis*is*p*.";
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isMatch(s1, p1));
        System.out.println(solution1.isMatch(s2, p2));
        System.out.println(solution1.isMatch(s3, p3));
        System.out.println(solution1.isMatch(s4, p4));
        System.out.println(solution1.isMatch(s5, p5));
    }
}
