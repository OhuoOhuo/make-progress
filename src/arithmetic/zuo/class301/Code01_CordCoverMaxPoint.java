package arithmetic.zuo.class301;

import java.util.Arrays;

/*
给定一个有序的整数数组，其中每个数都代表在坐标轴上的数字，
给定一个整数K代表线段的长度，求该线段的长度最多能覆盖的点数
 *
 整体的贪心策略：以某个点开头或以某个点结尾

 解法1：以某个点开头根据长度，二分查找到最近的点，O(n * logn)

 解法2：滑动窗口，O(n)
 */
public class Code01_CordCoverMaxPoint {


    private static int maxPoint1(int[] arr, int l) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int index = getPoint(arr, i, arr[i] + l);
            ans = Math.max(ans, index - i + 1);
        }
        return ans;
    }

    //在L 下标之后，找到 <= value   的最大值
    private static int getPoint(int[] arr, int L, int value) {
        int R = arr.length - 1;
        int index = L;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] <= value) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }


    private static int maxPoint2(int[] arr, int len) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int ans = 0;
        int L = 0;
        int R = 0;
        while (L <= R && R < arr.length) {
            while (R < arr.length && arr[R] <= arr[L] + len) {
                R++;
            }
            ans = Math.max(ans, R - L);
            L++;
        }
        return ans;
    }


    // for test
    public static int test(int[] arr, int L) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int pre = i - 1;
            while (pre >= 0 && arr[i] - arr[pre] <= L) {
                pre--;
            }
            max = Math.max(max, i - pre);
        }
        return max;
    }

    // for test
    public static int[] generateArray(int len, int max) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int len = 100;
        int max = 1000;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int L = (int) (Math.random() * max);
            int[] arr = generateArray(len, max);
            int ans1 = maxPoint1(arr, L);
            int ans2 = maxPoint2(arr, L);
            int ans3 = test(arr, L);
              if (ans1 != ans2 || ans2 != ans3) {
           // if (ans1 != ans3) {
                System.out.println("oops!");
                System.out.println(ans1 + "   " + ans3);
                break;
            }
        }

    }


}
