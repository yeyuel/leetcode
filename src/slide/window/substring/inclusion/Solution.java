package slide.window.substring.inclusion;


public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        int[] hash = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            hash[s1Arr[i] - 'a'] ++;
        }
        int l = 0, count = 0;
        for (int r = 0; r < s2Arr.length; r++) {
            hash[s2Arr[r] - 'a'] --;

            if (hash[s2Arr[r] - 'a'] >= 0) {
                count++;
            }

            while (r - l + 1 > s1Arr.length) {
                hash[s2Arr[l] - 'a']++;
                if (hash[s2Arr[l] - 'a'] >= 1) {
                    count --;
                }
                l++;
            }
            if (count == s1.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "bd";
        String s2 = "eidbaooo";
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion(s1, s2));
    }
}
