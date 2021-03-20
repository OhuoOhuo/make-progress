package arithmetic.leetcode;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 */
public class Code05 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
        System.out.println(findMedianSortedArrays(new int[]{0,0},new int[]{0,0}));
        System.out.println(findMedianSortedArrays(new int[]{},new int[]{1}));
        System.out.println(findMedianSortedArrays(new int[]{2},new int[]{}));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        if (nums1.length == 0) {
            return getOneArrayMedian(nums2);
        }
        if (nums2.length == 0) {
            return getOneArrayMedian(nums1);
        }

        int[] newArr = meger(nums1, nums2);

        return getOneArrayMedian(newArr);

    }

    private static int[] meger(int[] nums1, int[] nums2) {
        int[] newArr = new int[nums1.length + nums2.length];

        int newP = 0;
        int oneP = 0;
        int twoP = 0;
        while (oneP < nums1.length && twoP < nums2.length) {
            if (nums1[oneP] < nums2[twoP]) {
                newArr[newP++] = nums1[oneP++];
            } else {
                newArr[newP++] = nums2[twoP++];
            }
        }
        while (oneP<nums1.length){//数组1没放完
            newArr[newP++] =nums1[oneP++];
        }
        while (twoP<nums2.length){//数组2没放完
            newArr[newP++] = nums2[twoP++];
        }
        return newArr;
    }

    public static double getOneArrayMedian(int[] arr) {
        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0;
        } else {
            return arr[arr.length / 2];
        }
    }
}
