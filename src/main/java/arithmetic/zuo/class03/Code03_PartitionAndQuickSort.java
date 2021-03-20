package arithmetic.zuo.class03;

/**
 * 快速排序
 *
 *  partition 问题：给定一个数和一个数组，要求把数组中大于该数的放在左边，小于该数的放在右边（左右不要求有序）
 *
 *  荷兰国旗问题：给定一个数和一个数组，要求把数组中大于该数的放在左边，小于该数的放在右边，（左右不要求有序）等于该数的放在中间
 *
 *  快排：
 *  在上述两个基础上，递归的能够排序出来
 */
public class Code03_PartitionAndQuickSort {


    private static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lastEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lastEqual);
            }
            index++;
        }
        swap(arr, ++lastEqual, R);
        return lastEqual;
    }

    private static int partition1(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lastEqual = L - 1;
        int num = arr[R];
        int index = L;
        while (index < R + 1) {
            if (arr[index] <= num) {
                swap(arr, ++lastEqual, index);
            }
            index++;
        }
        return lastEqual;
    }

    private static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{1, 1};
        }
        int num = arr[R];
        int index = L;
        int leftArea = L - 1;
        int rightArea = R + 1;
        while (index < rightArea) {
            if (arr[index] < num) {
                swap(arr, ++leftArea, index++);
            } else if (arr[index] > num) {
                swap(arr, --rightArea, index);
            } else {
                index++;
            }
        }
        return new int[]{leftArea + 1, rightArea - 1};
    }


    private static void swap(int[] arr, int index, int i) {
        int temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }


    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;

        int[] arr1 = generateRandomArray(maxSize, maxValue);
        int[] arr2 = copyArray(arr1);
        int[] arr3 = copyArray(arr1);
        int[] arr4 = copyArray(arr1);
        int[] arr5 = copyArray(arr1);
        int[] arr6 = copyArray(arr1);

        printArray(arr1);
        int partition = partition(arr1, 0, arr1.length - 1);
        printArray(arr1);
        System.out.println(partition);

        int i = partition1(arr2, 0, arr2.length - 1);
        printArray(arr2);
        System.out.println(i);

        int[] ints = netherlandsFlag(arr3, 0, arr3.length - 1);
        printArray(arr3);
        printArray(ints);

        quickSort(arr4);
        printArray(arr4);

        quickSort1(arr5);
        printArray(arr5);

        quickSort2(arr6);
        printArray(arr6);

    }

    private static void quickSort2(int[] arr6) {
        if (arr6 ==null|| arr6.length-1<2){
            return;
        }
        process3(arr6,0,arr6.length-1);
    }

    private static void process3(int[] arr6, int L, int R) {
        if(L >=R){
            return;
        }
        swap(arr6,L+(int)(Math.random()*(R-L+1)),R);
        int[] ints = netherlandsFlag(arr6, L, R);
        process3(arr6,L,ints[0]-1);
        process3(arr6,ints[0]+1,R);
    }

    private static void quickSort1(int[] arr5) {
        if(arr5 ==null || arr5.length<2){
            return;
        }
        process2(arr5,0,arr5.length-1);
    }

    private static void process2(int[] arr5, int L, int R) {
        if(L >=R){
            return;
        }
        int[] m = netherlandsFlag(arr5, L, R);
        process2(arr5,L,m[0]-1);
        process2(arr5,m[1]+1,R);
    }


    private static void quickSort(int[] arr4) {
        if (arr4 == null || arr4.length < 2) {
            return;
        }
        process1(arr4, 0, arr4.length - 1);
    }

    private static void process1(int[] arr4, int L, int R) {
        if (L >= R) {
            return;
        }
        int m = partition(arr4, L, R);
        process1(arr4,L,m-1);
        process1(arr4,m+1,R);
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


}
