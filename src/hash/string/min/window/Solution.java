package hash.string.min.window;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static final int MAX_ARRAY_LEN = 128;

    public String minWindow(String s, String t) {
        int[] mapT = new int[MAX_ARRAY_LEN];
        int[] mapS = new int[MAX_ARRAY_LEN];
        for (int i = 0; i < t.length(); i++) {
            mapT[t.charAt(i)] ++;
        }
        List<Integer> vecT = new ArrayList<>();
        for (int i = 0; i < MAX_ARRAY_LEN; i++) {
            if (mapT[i] > 0) {
                vecT.add(i);
            }
        }
        int windowBegin = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            mapS[s.charAt(i)] ++;
            while (windowBegin < i) {
                char beginCh = s.charAt(windowBegin);
                if (mapT[beginCh] == 0) {
                    windowBegin ++;
                } else if (mapS[beginCh] > mapT[beginCh]) {
                    mapS[beginCh]--;
                    windowBegin++;
                } else {
                    break;
                }
            }
            if (isWindowOK(mapS, mapT, vecT)) {
                int newWindowLen = i - windowBegin + 1;
                if ("".equals(result) || result.length() > newWindowLen) {
                    result = s.substring(windowBegin, i + 1);
                }
            }
        }
        return result;
    }

    private boolean isWindowOK(int[] mapS, int[] mapT, List<Integer> vectT) {
        for (int i = 0; i < vectT.size(); i++) {
            if (mapS[vectT.get(i)] < mapT[vectT.get(i)]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t));
    }
}
