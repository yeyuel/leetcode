package hash.string.longest.substring;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int begin = 0;
        int result = 0;
        String word = "";
        int[] charMap = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charMap[c] ++;
            if (charMap[c] == 1) {
                word += c;
                if (result < word.length()) {
                    result = word.length();
                }
            } else {
                while (begin < i && charMap[c] > 1) {
                    charMap[s.charAt(begin)] --;
                    begin ++;
                }
                word = "";
                for (int j = begin; j <= i; j++) {
                    word += s.charAt(j);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String sample1 = "abcabcbb";
        String sample2 = "bbbbb";
        String sample3 = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(sample1));
        System.out.println(solution.lengthOfLongestSubstring(sample2));
        System.out.println(solution.lengthOfLongestSubstring(sample3));
    }
}
