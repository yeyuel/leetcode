package reverse.string;

public class Solution {

    public void reverseString(char[] s) {
        if (s.length < 2) {
            return;
        }
        int i = 0, j = s.length - 1;
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i ++;
            j --;
        }
    }

    public static void main(String[] args) {
        char[] input1 = {'h', 'e', 'l', 'l', 'o'};
        char[] input2 = {'H','a','n','n','a','h'};

        Solution solution = new Solution();
        solution.reverseString(input1);
        solution.reverseString(input2);
        System.out.println(input1);
        System.out.println(input2);
    }
}
