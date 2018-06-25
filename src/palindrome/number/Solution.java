package palindrome.number;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int cur = x;
        int palindrome = 0;
        while (cur != 0) {
            int digit = cur % 10;
            palindrome = palindrome * 10 + digit;
            cur = cur / 10;
        }
        return palindrome == x;
    }

    public static void main(String[] args) {
        int test1 = 121;
        int test2 = -121;
        int test3 = 10;
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(test1));
        System.out.println(solution.isPalindrome(test2));
        System.out.println(solution.isPalindrome(test3));
    }
}
