package advanced.datastructure.range.sum.query;

public class NumArray {

    private int[] values;
    private int rightEnd;

    public NumArray(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int n = nums.length * 4;
        values = new int[n];
        this.rightEnd = nums.length - 1;
        buildSegementTree(values, nums, 0, 0, rightEnd);
    }

    public void update(int i, int val) {
        updateSegmentTree(values, 0, 0, rightEnd, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRangeSegmentTree(values, 0, 0, rightEnd, i, j);
    }

    private void buildSegementTree(int[] values,
                                   int[] nums,
                                   int pos,
                                   int left,
                                   int right) {
        if (left == right) {
            values[pos] = nums[left];
            return;
        }
        int mid = (left + right) / 2;
        buildSegementTree(values, nums, pos * 2 + 1, left, mid);
        buildSegementTree(values, nums, pos * 2 + 2, mid + 1, right);
        values[pos] = values[pos * 2 + 1] + values[pos * 2 + 2];
    }

    public void printSegementTree() {
        printSegementTree(this.values, 0, 0, rightEnd, 0);
    }

    private void printSegementTree(int[] values,
                                   int pos,
                                   int left,
                                   int right,
                                   int layer) {
        for (int i = 0; i < layer; i++) {
            System.out.print("---");
        }
        System.out.printf("[%d %d][%d] : %d\n", left, right, pos, values[pos]);
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        printSegementTree(values, pos * 2 + 1, left, mid, layer + 1);
        printSegementTree(values, pos * 2 + 2, mid + 1, right, layer + 1);
    }

    private int sumRangeSegmentTree(int[] values,
                                    int pos,
                                    int left,
                                    int right,
                                    int qLeft,
                                    int qRight) {
        if (qLeft > right || qRight < left) {
            return 0;
        }
        if (qLeft <= left && qRight >= right) {
            return values[pos];
        }
        int mid = (left + right) / 2;
        return sumRangeSegmentTree(values, pos * 2 + 1, left, mid, qLeft, qRight)
                + sumRangeSegmentTree(values, pos * 2 + 2, mid + 1, right, qLeft, qRight);
    }

    private void updateSegmentTree(int[] values,
                                   int pos,
                                   int left,
                                   int right,
                                   int index,
                                   int newValue) {
        if (left == right && left == index) {
            values[pos] = newValue;
            return;
        }
        int mid = (left + right) / 2;
        if (index <= mid) {
            updateSegmentTree(values, pos * 2 + 1, left, mid, index, newValue);
        } else {
            updateSegmentTree(values, pos * 2 + 2, mid + 1, right, index, newValue);
        }
        values[pos] = values[pos * 2 + 1] + values[pos * 2 + 2];
    }

    public static void main(String[] args) {
        int[] sample = {1, 3, 5};
        NumArray obj = new NumArray(sample);
        obj.printSegementTree();
        System.out.println(obj.sumRange(0, 2));
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2));
    }
}
