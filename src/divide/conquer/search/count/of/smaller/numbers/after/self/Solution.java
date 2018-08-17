package divide.conquer.search.count.of.smaller.numbers.after.self;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> countSmaller(int[] nums) {
        List<int[]> vect = new ArrayList<>();
        int count[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            vect.add(new int[] {nums[i], i});
            count[i] = 0;
        }
        mergeSort(vect, count);
        List<Integer> result = new ArrayList<>();
        for (int c : count) {
            result.add(c);
        }
        return result;
    }

    private void mergeSortTwoVec(List<int[]> subVect1,
                                 List<int[]> subVect2,
                                 List<int[]> vect,
                                 int[] count) {
        int i = 0;
        int j = 0;
        while (i < subVect1.size() && j < subVect2.size()) {
            if (subVect1.get(i)[0] <= subVect2.get(j)[0]) {
                count[subVect1.get(i)[1]] += j;
                vect.add(subVect1.get(i));
                i++;
            } else {
                vect.add(subVect2.get(j));
                j++;
            }
        }
        for (; i < subVect1.size(); i++) {
            count[subVect1.get(i)[1]] += j;
            vect.add(subVect1.get(i));
        }
        for (; j < subVect2.size(); j++) {
            vect.add(subVect2.get(j));
        }
    }

    private void mergeSort(List<int[]> vec,
                           int[] count) {
        if (vec.size() < 2) {
            return;
        }
        int mid = vec.size() / 2;
        List<int[]> subVec1 = new ArrayList<>();
        List<int[]> subVec2 = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            subVec1.add(vec.get(i));
        }
        for (int i = mid; i < vec.size(); i++) {
            subVec2.add(vec.get(i));
        }
        mergeSort(subVec1, count);
        mergeSort(subVec2, count);
        vec.clear();
        mergeSortTwoVec(subVec1, subVec2, vec, count);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sample = new int[] {5,2,6,1};
        System.out.println(solution.countSmaller(sample));
    }
}
