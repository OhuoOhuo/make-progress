package arithmetic.zuo.class201;

import java.util.LinkedList;

/**
 * 给定一个数组，和一个数；
 * 它的子数组中的最大值 - 最小值<= 给定数 ，该子数组为有效数组，求有效数组的个数。
 * <p>
 * 暴力解法：求出所有子数组，再一一判所有子数组是否满足
 */
public class Code02_AllLessNumSubArray {


    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();

        int L = 0;
        int R = 0; //表示滑动窗口的最后一个有效值的下一个，即该次窗口的第一个无效值，也是下一次窗口滑动时第一个判断的值

        int result = 0;

        while (L < arr.length) {     //计算出已L开头的所有情况，依次累加即为最后结果
            while (R< arr.length){
                //加入到维持的队列中
                while (!qmax.isEmpty()&& arr[qmax.peekLast()]<=arr[R]){
                    qmax.pollLast();
                }
                qmax.addLast(R);
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]) {
                    qmin.pollLast();
                }
                qmin.addLast(R);

                if(arr[qmax.getFirst()] - arr[qmin.getFirst()] >num){  //如果R不满足，则R+1也不满足
                    break;
                }
                R++;
            }

            result += R-L;   //如果 在窗口内 L ——R 满足，L+1 到R也满足，数据状况的常用分析方法

            if(L == qmin.peekFirst()){
                qmin.pollFirst();
            }
            if(L == qmax.peekFirst()){
                qmax.pollFirst();
            }

            L++;
        }

        return result;
    }


    // for test
    public static int[] getRandomArray(int len) {
        if (len < 0) {
            return null;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    //for test
    public static int getNum1(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int L = 0;
        int R = 0;
        // [L..R) -> [0,0) 窗口内无数 [1,1)
        // [0,1) -> [0~0]
        int res = 0;
        while (L < arr.length) { // L是开头位置，尝试每一个开头

            // 如果此时窗口的开头是L,下面的while工作:R向右扩到违规为止

            while (R < arr.length) { // R是最后一个达标位置的再下一个
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]) {
                    qmin.pollLast();
                }
                qmin.addLast(R);
                // R -> arr[R],
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                    qmax.pollLast();
                }
                qmax.addLast(R);

                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                R++;
            }

            // R是最后一个达标位置的再下一个，第一个违规的位置
            res += R - L;

            if (qmin.peekFirst() == L) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == L) {
                qmax.pollFirst();
            }

            L++;

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = getRandomArray(30);
        int num = 5;
        printArray(arr);
        System.out.println(getNum(arr, num));
        System.out.println(getNum1(arr,num));

    }
}
