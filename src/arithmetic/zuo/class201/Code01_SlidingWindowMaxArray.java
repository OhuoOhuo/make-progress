package arithmetic.zuo.class201;

import java.util.LinkedList;

/**
 * 滑动窗口
 * L R   L<=R,L R 都只能加不能减
 * 用一个双端队列来记录最大值，最小值，该队列可以 记录从此时起，如果R不在移动，L向右移动依次的最大值
 */
public class Code01_SlidingWindowMaxArray {

    /**
     * 给定一个数组，和固定大小的窗口，求窗口从左到右滑动的最大值
     * 如[5,6,7,2,4,9]  w=3 返回 [7,7,7,9]
     * 暴力解：找出R 到arr.length 的所有集合，求出每个的最大值
     */
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        int[] result = new int[arr.length - w + 1];
        int index = 0;

        LinkedList<Integer> maxList = new LinkedList<>();//双端队列，里面记录的是对应值在数组的下标

        for (int i = 0; i < w; i++) {//初始化滑动窗口
            while (!maxList.isEmpty() && arr[maxList.peekLast()] <= arr[i]) {
                maxList.pollLast();
            }
            maxList.addLast(i);
        }
        result[index++] = arr[maxList.peekFirst()];

        for (int i = w; i < arr.length; i++) {
            while (!maxList.isEmpty() && arr[maxList.peekLast()] <=arr[i]){
                maxList.pollLast();
            }
            maxList.addLast(i);
            if(maxList.getFirst()== (i-w)){
                maxList.pollFirst();
            }
            result[index++] = arr[maxList.peekFirst()];
        }

        return result;
    }


    public static void main(String[] args) {
        int testTime = 100000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int w = (int) (Math.random() * (arr.length + 1));
            int[] ans1 = getMaxWindow(arr, w);
            int[] ans2 = rightWay(arr, w);
            if (!isEqual(ans1, ans2)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }

    // for test
    public static int[] rightWay(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        int L = 0;
        int R = w - 1;
        while (R < arr.length) {
            int max = arr[L];
            for (int i = L + 1; i <= R; i++) {
                max = Math.max(max, arr[i]);

            }
            res[index++] = max;
            L++;
            R++;
        }
        return res;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


}
