package advanced.datastructure.range.sum.query;

public class NumArray {

    public NumArray(int[] nums) {

    }

    public void update(int i, int val) {

    }

    public int sumRange(int i, int j) {
        return 0;
    }

    public static void main(String[] args) {
        int[] sample = {1, 3, 5};
        NumArray obj = new NumArray(sample);
        System.out.println(obj.sumRange(0, 2));
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2));
    }
}
