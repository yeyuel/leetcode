package hash.string.repeated.dna.sequences;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static final char DNA_CHAR[] = {'A', 'C', 'G', 'T'};
    private static final int TOTAL = 1048576;

    public List<String> findRepeatedDnaSequences(String s) {
        int[] gHashMap = new int[TOTAL];
        List<String> result = new ArrayList<>();
        if (s.length() < 10) {
            return result;
        }
        int[] charMap = new int[128];
        charMap['A'] = 0;
        charMap['C'] = 1;
        charMap['G'] = 2;
        charMap['T'] = 3;
        int key = 0;
        for (int i = 9; i >= 0; i--) {
            key = (key << 2) + charMap[s.charAt(i)];
        }
        gHashMap[key] = 1;
        for (int i = 10; i < s.length(); i++) {
            key = key >> 2;
            key = key | (charMap[s.charAt(i)] << 18);
            gHashMap[key]++;
        }
        for (int i = 0; i < TOTAL; i++) {
            if (gHashMap[i] > 1) {
                result.add(changeIntToDNA(i));
            }
        }
        return result;
    }

    private String changeIntToDNA(int DNA) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(DNA_CHAR[DNA & 3]);
            DNA = DNA >> 2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String sample = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(solution.findRepeatedDnaSequences(sample));
    }
}
