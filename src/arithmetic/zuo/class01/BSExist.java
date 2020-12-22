package arithmetic.zuo.class01;

import java.util.Arrays;


/**
 * 二分查找，一般用于有序的数组，其它情况得关注数据状况，和题目需求
 */
public class BSExist {


    public static boolean exist(int[] sortedArr, int num) {
        if(sortedArr ==null || sortedArr.length ==0){
            return false;
        }
        int left =0;
        int right = sortedArr.length -1;
        int mid = 0;
        while (left <= right){
            mid = (left +right)/2;

            if(sortedArr[mid] ==num){
                return true;
            }else if(sortedArr[mid] >num){
                right = mid -1;
            }else {
                left = mid+1;
            }
        }
        return false;
    }

    // for test
    public static boolean test(int[] sortedArr, int num) {
        for(int cur : sortedArr) {
            if(cur == num) {
                return true;
            }
        }
        return false;
    }


    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

   public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != exist(arr, value)) {
                succeed = false;
                System.out.println(Arrays.toString(arr) +"::" +value);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

/*    public static void main(String[] args) {
        int[] arr={-4,0,31};
        exist(arr,-4);

    }*/




}
