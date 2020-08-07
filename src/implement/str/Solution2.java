package implement.str;

public class Solution2 {

    int kmp(String text, String pattern) {
        int i = 0, j = 0;
        int[] next = getNext(pattern);
        while (i < text.length() && j < pattern.length()) {
            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pattern.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        for (int i = 0; i < next.length; i++) {
            next[i] = -1;
        }
        int i = 0, j = -1;
        while (i < pattern.length()) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String haystack1 = "hello", needle1 = "ll";
        String haystack2 = "aaaa", needle2 = "bba";
        String haystack3 = "mississippi", needle3 = "issipi";
        System.out.println(solution.kmp(haystack1, needle1));
        System.out.println(solution.kmp(haystack2, needle2));
        System.out.println(solution.kmp(haystack3, needle3));
    }

}
