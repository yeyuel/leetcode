package container.with.most.water;

public class Solution {
    public int maxArea(int[] height) {
        int begin = 0;
        int end = height.length - 1;
        int max = (end - begin) * Math.min(height[begin], height[end]);
        while (begin < end) {
            if (height[begin] < height[end]) {
                max = Math.max((end - begin) * height[begin], max);
                begin++;
            } else {
                max = Math.max((end - begin) * height[end], max);
                end --;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution().maxArea(heights));
    }
}
