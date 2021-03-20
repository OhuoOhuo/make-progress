package arithmetic.zuo.class302;

/**
 * 给定一个完全由正整数组成的数组，要求其中子数组之和为K 求最大子数组长度
 * 对于这种问题，首先考量单调性，本题和只能加不能减
 * 常用技巧：列举以数组中每个数字开头的所有情况，列举数组中每个数字结尾的所有情况
 * 单调栈
 */
public class LongestSumSubArrayLengthInPositiveArray {

    // for test
    public static int right(int[] arr, int K) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (valid(arr, i, j, K)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    // for test
    public static boolean valid(int[] arr, int L, int R, int K) {
        int sum = 0;
        for (int i = L; i <= R; i++) {
            sum += arr[i];
        }
        return sum == K;
    }

    // for test
    public static int[] generatePositiveArray(int size, int value) {
        int[] ans = new int[size];
        for (int i = 0; i != size; i++) {
            ans[i] = (int) (Math.random() * value) + 1;
        }
        return ans;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
/*        int[] arr =new int[]{91, 65 ,13, 99, 49, 28, 21, 33 ,39, 97, 66, 42 ,11, 30 ,10, 61, 8 ,61 ,71 ,46 ,8 ,56,
                64, 13 ,66, 14 ,6 ,42, 60 ,78 ,85 ,34 ,17 ,58, 62 ,39, 68, 49, 28 ,84 ,84, 56 ,38 ,9, 85 ,48 ,66, 5 ,48 ,57 };
        int maxLength = getMaxLength(arr, 57);
        System.out.println(maxLength);*/
        int len = 50;
        int value = 100;
        int testTime = 500000;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generatePositiveArray(len, value);
            int K = (int) (Math.random() * value) + 1;
            int ans1 = getMaxLength(arr, K);
            int ans2 = right(arr, K);
            if (ans1 != ans2) {
                System.out.println("Oops!");
                printArray(arr);
                System.out.println("K : " + K);
                System.out.println(ans1);
                System.out.println(ans2);
                break;
            }
        }
        System.out.println("test end");
    }

    public static int getMaxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }
        int L = 0;
        int R = 0;
        int sum = arr[0];//初始值
        int len = 0;

        while (R < arr.length) {
            if (sum == k) {
                len = Math.max(len, R - L+1);
                sum -= arr[L++];
            } else if (sum < k) {
                R++;
                if (R >= arr.length) {
                    break;
                }
                sum += arr[R];
            } else {
                sum -=arr[L++];
            }
        }
        return len;
    }
}
