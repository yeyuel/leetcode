package recursive.find.hard.string;

import java.util.*;

public class Solution {

    private static final char START = 'A';

    public List<String> findHardWords(int n, int l) {
        List<String> result = new ArrayList<>();
        findHardWords(n, l, START, new StringBuffer(), result);
        return result;
    }

    public void findHardWords(int n, int l, char current,
                              StringBuffer sb, List<String> result) {
        if (result.size() > n) {
            return;
        }
        if (current - START + 1 > l) {
            return;
        }
        sb.append(current);
        String candidate = sb.toString();
        if (isHard(candidate)) {
            result.add(candidate);

        }
        findHardWords(n, l, (char) (current + 1), sb, result);
        sb.deleteCharAt(sb.length() - 1);
        candidate = sb.toString();
        if (isHard(candidate)) {
            result.add(candidate);
        }
        findHardWords(n, l, (char) (current + 1), sb, result);
    }

    private boolean isHard(String input) {
        if (input.length() < 1) {
            return false;
        }
        Set<String> subStringSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                String subString = input.substring(i, j + 1);
                if (!subStringSet.add(subString)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.findHardWords(7, 3);
        System.out.println(result.toString());
    }
}
