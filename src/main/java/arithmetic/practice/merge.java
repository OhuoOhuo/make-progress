package arithmetic.practice;

public class merge {


    public static void main(String[] args) {
        int[] arr = {1,3,4,6,2,3,5,9};
        merge(arr,0,3,7);
        System.out.println();
    }
    public static void merge(int[] arr, int L, int mid, int R) {

        int[] help = new int[R - L + 1];

        int i = L;
        int j = mid + 1;
        int h = 0;

        while (i <= mid && j <= R) {
            if (arr[i] < arr[j]) {
                help[h++] = arr[i++];
            } else {
                help[h++] = arr[j++];
            }
        }
        while (i <= mid) {
            help[h++] = arr[i++];
        }
        while (j <= R) {
            help[h++] = arr[j++];
        }

        for (int k = 0; k < help.length; k++) {
            arr[L++] = help[k];
        }
    }
}
