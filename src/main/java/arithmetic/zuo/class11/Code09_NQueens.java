package arithmetic.zuo.class11;

public class Code09_NQueens {

    public static void main(String[] args) {
        int n = 8;
        System.out.println(num(n));


        System.out.println(num2(n));
    }

    private static int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        // 如果你是13皇后问题，limit 最右13个1，其他都是0
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit,0,0,0);
    }

    /**
     * 以二进制的方式，优化常数项
     * @param limit       定值
     * @param colLim      列限制
     * @param leftDiaLim  左斜线限制
     * @param rightDiaLim 右斜线限制
     * @return
     */
    public static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {
            return 1;
        }
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;

            res += process2(limit, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1, (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }


    private static int num(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process(0, record, n);
    }

    /**
     * @param index  到第几行摆皇后
     * @param record 记录第几行，第几列 摆了皇后，0....i-1 有效，例如 record[1]=3 表示在第二行 第四列摆了皇后
     * @param n      不变定值，n皇后问题
     * @return
     */
    private static int process(int index, int[] record, int n) {
        if (index == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isVaild(record, index, j)) {
                record[index] = j;
                res += process(index + 1, record, n);
                //record[index] = 0;
            }
        }
        return res;
    }

    /**
     * 判断当前位置是否可以摆放皇后
     */
    private static boolean isVaild(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) { // 之前的某个k行的皇后
            // k, record[k]   i, j
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }


}
