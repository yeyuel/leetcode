package greedy.remove.k.digits;

import java.util.LinkedList;

public class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Integer> s = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num.length(); i++) {
            int number = num.charAt(i) - '0';
            while (s.size() != 0 &&
                    s.get(s.size() - 1) > number &&
                    k > 0) {
                s.pollLast();
                k --;
            }
            if (number != 0 || s.size() != 0) {
                s.add(number);
            }
        }

        while (s.size() != 0 && k > 0) {
            s.pollLast();
            k --;
        }

        for (int i = 0; i < s.size(); i++) {
            sb.append((char)('0' + s.get(i)));
        }

        String ret = sb.toString();
        if ("".equals(ret)) {
            ret = "0";
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("1432219", 3));
        System.out.println(solution.removeKdigits("100200", 1));
    }
}
