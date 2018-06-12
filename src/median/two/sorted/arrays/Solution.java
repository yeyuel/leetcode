package median.two.sorted.arrays;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k1 = nums1.length + nums2.length + 1;
        int k2 = nums1.length + nums2.length + 2;
        return (findKSortedArrays(nums1, nums2, k1 / 2) + findKSortedArrays(nums1, nums2, k2 / 2)) / 2;
    }

    public double findKSortedArrays(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) {
            return nums2[k - 1];
        } else if (nums2.length == 0) {
            return nums1[k - 1];
        } else {
            return findKSortedArrays(nums1, nums2, k, 0, 0);
        }
    }

    public double findKSortedArrays(int[] nums1, int[] nums2, int k, int start1, int start2) {
        if (k <= 1) {
            if (start1 > nums1.length - 1) {
                return nums2[start2];
            } else if (start2 > nums2.length - 1) {
                return nums1[start1];
            } else {
                return Math.min(nums1[start1], nums2[start2]);
            }
        }
        int m = Math.min(k / 2, nums1.length - start1);
        int n = Math.min(k / 2, nums2.length - start2);
        if (m == 0) {
            return nums2[start2 + k - 1];
        }
        if (n == 0) {
            return nums1[start1 + k - 1];
        }
        if (nums1[start1 + m - 1] <= nums2[start2 + n - 1]) {
            return findKSortedArrays(nums1, nums2, k - m, start1 + m, start2);
        } else {
            return findKSortedArrays(nums1, nums2, k - n, start1, start2 + n);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3};
        int[] nums2 = new int[]{1, 2, 4, 5, 6, 7, 8};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
        System.out.println(new Solution().findKSortedArrays(nums1, nums2, 5));
    }
}
