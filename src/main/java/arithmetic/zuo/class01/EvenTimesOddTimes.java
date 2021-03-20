package arithmetic.zuo.class01;

/**
 * 位运算
 * 同或  相同为0，不同为1
 * <p>
 * 异或  不同为1，相同为0；理解为2进制的无进位相加
 * 0^ N =N  N^N=0  所以偶数个N ^ 为0
 *
 *
 */
public class EvenTimesOddTimes {

    /**
     * subject1
     * 一个数组中只有一个数值出现计数次，找出这个数
     *
     * @param arr
     */
    public static void printOddTimesNum1(int[] arr) {
        int err = 0;
        for (int i : arr) {
            err ^= i;
        }
        System.out.println(err);
    }

    /**
     * subject2
     * 把一个int类型的数，提取出最右的一个1
     *
     * @param
     */
    public static void bit1counts(int n) {
        System.out.println(n & (~n + 1));
    }

    /**
     * subject3
     * arr中，有两种数，出现奇数次,打印出两种数
     *
     * @param args
     */
    public static void printOddTimesNum2(int[] args) {
        //找到两种数的^
        int eor = 0;
        for (int i = 0; i < args.length; i++) {
            eor ^= args[i];
        }
        //如果args满足有两种数，出现基数次，则eor ！=0
        //则一定能找到eor最右的那个1
        int rightOne = eor & (~eor + 1);
        int one = 0;
        for (int i = 0; i < args.length; i++) {
            //通过最右为1 把数组分成两种数据，其中一种相亦或一定为其中一个树
            if ((args[i] & rightOne) == 0) {
                one ^= args[i];
            }
        }
        System.out.println(one + "  " + (one ^ eor));
    }

    /**
     * @param args
     */

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 1, 3, 4, 4, 4};

        printOddTimesNum1(arr1);
        bit1counts(66);

        int[] arr2 = {1, 2, 2, 3, 1, 3, 4, 4, 4, 5, 5, 9, 9, 9};
        printOddTimesNum2(arr2);

        int a = 3, b = 4;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);

        int[] arr3 = {1, 2, 3};
        swap(arr3, 0, 2);
        System.out.println(arr3[0] + " " + arr3[2]);
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
