package arithmetic.zuo.class201;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 单调栈
 * <p>
 * 给定一个数组，求每个位置上 左边离他最近的比它小的位置，右边离他最近的比它小的位置
 * 暴力获取，n*n
 * 使用单调栈，n
 */
public class Code03_MonotonousStack {


    // for test
    public static int[] getRandomArrayNoRepeat(int size) {
        int[] arr = new int[(int) (Math.random() * size) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            int swapIndex = (int) (Math.random() * arr.length);
            int tmp = arr[swapIndex];
            arr[swapIndex] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }

    // for test
    public static int[] getRandomArray(int size, int max) {
        int[] arr = new int[(int) (Math.random() * size) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max) - (int) (Math.random() * max);
        }
        return arr;
    }

    // for test
    public static int[][] rightWay(int[] arr) {
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int leftLessIndex = -1;
            int rightLessIndex = -1;
            int cur = i - 1;
            while (cur >= 0) {
                if (arr[cur] < arr[i]) {
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            cur = i + 1;
            while (cur < arr.length) {
                if (arr[cur] < arr[i]) {
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = leftLessIndex;
            res[i][1] = rightLessIndex;
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[][] res1, int[][] res2) {
        if (res1.length != res2.length) {
            return false;
        }
        for (int i = 0; i < res1.length; i++) {
            if (res1[i][0] != res2[i][0] || res1[i][1] != res2[i][1]) {
                return false;
            }
        }

        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int size = 10;
        int max = 20;
        int testTimes = 2000000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = getRandomArrayNoRepeat(size);
            int[] arr2 = getRandomArray(size, max);
            int[][] nearLessNoRepeat = getNearLessNoRepeat(arr1);
            int[][] ints = rightWay(arr1);
            if (!isEqual(getNearLessNoRepeat(arr1), rightWay(arr1))) {
                System.out.println("Oops!");
                printArray(arr1);
                break;
            }
/*            if (!isEqual(getNearLess(arr2), rightWay(arr2))) {
                System.out.println("Oops!");
                printArray(arr2);
                break;
            }*/
        }
    }

    //获取单调栈

    /*
     * [4,3,5,0,1,6]
     *
     * 用数组n * 2 的数组表示
     *
     * 0 [-1,1]
     * 1 [-1,3]  表示数组的1位置的数，左边没有比它小的数，右边比它小的数最近的是3位置
     *
     */
    private static int[][] getNearLessNoRepeat(int[] arr) {
        int[][] result = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            // 底 -> 顶， 小 -> 大
            while (!stack.isEmpty() && arr[i] < arr[stack.peek().get(0)]) {
                List<Integer> pop = stack.pop();
                int leftMin = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                for (Integer popi : pop) {
                    result[popi][0] = leftMin;
                    result[popi][1] = i;//右边小于最近的数就是i
                }
            }
            if (!stack.isEmpty() && arr[i] == arr[stack.peek().get(0)]) {
                stack.peek().add(i);
            } else {
                ArrayList<Integer> integers = new ArrayList<>();
                integers.add(i);
                stack.push(integers);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            int leftMin = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            for (Integer integer : pop) {
                result[integer][0] = leftMin;
                result[integer][1] = -1;
            }
        }
        return result;
    }
}
