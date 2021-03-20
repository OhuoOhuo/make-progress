package arithmetic.zuo.class01;

import java.util.Arrays;

/**
 * 时间复杂度为O(n平方)的排序
 * 选择
 * 插入：把新的一个数值，插入到已经排好序的数组里，
 * 冒泡
 */
public class ONSort {

    // 交换arr的i和j位置上的值
    public static void swap(int[] arr, int i, int j) {
/*        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];*/
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
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

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            int[] arr4 = copyArray(arr1);
            insertionSort(arr3);
            bubbleSort(arr1);
            comparator(arr2);
            selectSort(arr4);
            if (!isEqual(arr2, arr3) || !isEqual(arr2, arr4)||!isEqual(arr1,arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

/*        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);*/
    }

    //选择排序
    private static void selectSort(int[] arr4) {
        if (arr4 == null || arr4.length < 2) {
            return;
        }
        for (int i = 0; i < arr4.length; i++) {
            int lastIndex = i;
            for (int j = i + 1; j < arr4.length; j++) {
                if (arr4[j] < arr4[lastIndex]) {
                    lastIndex = j;
                }
            }
            swap(arr4, i, lastIndex);
        }
    }

    //插入排序
    private static void insertionSort(int[] arr3) {
        if (arr3 == null || arr3.length < 2) {
            return;
        }
        for (int i = 1; i < arr3.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr3[i] < arr3[j]) {
                    swap(arr3, i, j);
                }
            }
        }
    }

    //冒泡排序
    private static void bubbleSort(int[] arr1) {
        if (arr1 == null || arr1.length < 2) {
            return;
        }
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i + 1; j < arr1.length; j++) {
                  if(arr1[j] <arr1[i]){
                      swap(arr1,i,j);
                  }
            }
        }
    }
}
