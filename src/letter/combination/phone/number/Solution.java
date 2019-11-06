/*
 * Copyright (c) 2019 NeuLion, Inc. All Rights Reserved.
 */
package letter.combination.phone.number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Solution.
 *
 * @author <A HREF="mailto:eric.ding@neulion.com.cn">Eric.Ding</A>
 * @version 1.0, $Revision: 0$, $Date: 2019/11/6$
 * @since 1.0
 */
public class Solution
{
    private String[] two = { "a", "b", "c" };
    private String[] three = {"d", "e", "f"};
    private String[] four = { "g", "h", "i" };
    private String[] five = { "j", "k", "l" };
    private String[] six = { "m", "n", "o" };
    private String[] seven = { "p", "q", "r", "s" };
    private String[] eight = { "t", "u", "v" };
    private String[] nine = { "w", "x", "y", "z" };

    public List<String> letterCombinations(String digits)
    {
        ArrayList<String> ret = new ArrayList<>();
        Map<String, String[]> letterMap = new HashMap<>();
        letterMap.put("2", two);
        letterMap.put("3", three);
        letterMap.put("4", four);
        letterMap.put("5", five);
        letterMap.put("6", six);
        letterMap.put("7", seven);
        letterMap.put("8", eight);
        letterMap.put("9", nine);
        generateCombinations(digits, new StringBuilder(), ret, letterMap);
        return ret;
    }

    private void generateCombinations(String digits, StringBuilder cur,
            List<String> ret, Map<String, String[]> letterMap)
    {
        if (digits.length() == 0)
        {
            if (cur.length() > 0)
            {
                ret.add(cur.toString());
            }
            return;
        }
        String currentDigit = digits.substring(0, 1);
        if (letterMap.containsKey(currentDigit))
        {
            String[] chs = letterMap.get(currentDigit);
            for (String ch : chs)
            {
                cur.append(ch);
                generateCombinations(digits.substring(1), cur, ret, letterMap);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
        else
        {
            generateCombinations(digits.substring(1), cur, ret, letterMap);
        }
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }
}
