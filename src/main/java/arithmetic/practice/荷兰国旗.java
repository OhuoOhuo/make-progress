package arithmetic.practice;

public class 荷兰国旗 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 2, 4, 5, 3};
        // swap(arr,0,1);

        int[] b = change(arr, 3);
        System.out.println();
    }

    private static int[] change(int[] arr, int val) {
        int[] res = new int[2];

        int small = -1;
        int big = arr.length;

        int i = 0;
        while (i < big) {
            if (arr[i] < val) {
                swap(arr, i++, ++small);
            } else if (arr[i] == val) {
                i++;
            } else {
                swap(arr, i, --big);
            }
        }
        res[0] = small + 1;
        res[1] = big - 1;
        return res;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
