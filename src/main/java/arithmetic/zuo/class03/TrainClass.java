package arithmetic.zuo.class03;

public class TrainClass {


    public static void main(String[] args) {

        int maxSize = 100;
        int maxValue = 100;

        int[] arr1 = generateRandomArray(maxSize, maxValue);
        int[] arr2 = copyArray(arr1);
        int[] arr3 = copyArray(arr1);
        int[] arr4 = copyArray(arr1);

        printArray(arr1);
        int index = partition(arr1, 0, arr1.length - 1);
        printArray(arr1);
        System.out.println(index);

        int[] ints = netherlandsFlag(arr2, 0, arr2.length - 1);
        printArray(arr2);
        printArray(ints);

        quickSort(arr3);
        printArray(arr3);
        quickSort1(arr4);
        printArray(arr4);
    }

    private static void quickSort1(int[] arr4) {
        if (arr4 == null || arr4.length < 2) {
            return;
        }
        process2(arr4, 0, arr4.length - 1);
    }

    private static void process2(int[] arr4, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] ints = netherlandsFlag(arr4, L, R);
        process2(arr4,L,ints[0]-1);
        process2(arr4,ints[1]+1,R);
    }

    private static void quickSort(int[] arr3) {
        if (arr3 == null || arr3.length < 2) {
            return;
        }
        process(arr3, 0, arr3.length - 1);
    }

    private static void process(int[] arr3, int L, int R) {
        if (L >= R) {
            return;
        }
        int m = partition(arr3, L, R);
        process(arr3, L, m - 1);
        process(arr3, m + 1, R);
    }


    private static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{0, 0};
        }

        int num = arr[R];
        int leftArea = L - 1;
        int rightArea = R + 1;
        int index = L;
        while (index < rightArea) {
            if (arr[index] < num) {
                swap(arr, ++leftArea, index++);
            } else if (arr[index] == num) {
                index++;
            } else {
                swap(arr, --rightArea, index);
            }
        }
        return new int[]{leftArea + 1, rightArea - 1};

    }

    private static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int num = arr[R];
        int leftArea = L - 1;
        int index = L;
        while (index <= R) {
            if (arr[index] <= num) {
                swap(arr, ++leftArea, index);
            }
            index++;
        }
        return leftArea;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
