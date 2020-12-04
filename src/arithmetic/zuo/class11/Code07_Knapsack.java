package arithmetic.zuo.class11;

/**
 * 背包问题
 * 给定两个数组一个代表重量 ，一个代表价值，给定一个背包（限定可以背的总重量），求能背的最大价值
 * <p>
 * 暴力解法：
 * 即为列举所有可能情况
 * 最暴力的：列举出全排列，和全部的受益，挑选满足条件的收益最大的组合；
 * 次暴力的：根据背包的大小来决定是否添加进去
 */
public class Code07_Knapsack {

    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7};
        int[] values = {5, 6, 3, 19};
        int bag = 13;
        System.out.println(maxValue(weights, values, bag));
        System.out.println(dpWay(weights, values, bag));
    }

    private static int maxValue(int[] weights, int[] values, int bag) {

        return process(weights, values, 0, bag);
        //return process(weights, values, 0, 0, bag);
    }

    /**
     * @param weights
     * @param values
     * @param i        决定i位置
     * @param bag      背包总重量
     * @param readyBag 背包重量
     * @return 最大的价值
     */
    private static int process(int[] weights, int[] values, int i, int readyBag, int bag) {
        if (readyBag > bag) {
            return -1;
        }
        if (i == values.length) {
            return 0;
        }
        //不选择当前,背包重量不变，所以i+1 基础上也不会有返回-1的情况
        int p1 = process(weights, values, i + 1, readyBag, bag);
        //选择当前的,背包重量变大，i+1基础上有可能返回-1，如果i+1返回-1，则证明选择了当前i值，则超过了背包总重量，所以不能选择当前i值，
        int p2Next = process(weights, values, i + 1, readyBag + weights[i], bag);
        int p2 = p2Next == -1 ? -1 : values[i] + p2Next;
        return Math.max(p1, p2);
    }

    /**
     * @param weights
     * @param values
     * @param i
     * @param restBag 剩下背包重量
     * @return
     */
    private static int process(int[] weights, int[] values, int i, int restBag) {
        if (restBag < 0) {
            return -1;
        }
        if (i == weights.length) {
            return 0;
        }
        //不选择当前
        int p1 = process(weights, values, i + 1, restBag);
        //选择当前
        int p2Next = process(weights, values, i + 1, restBag - weights[i]);
        int p2 = p2Next == -1 ? -1 : p2Next + values[i];
        return Math.max(p1, p2);
    }

    private static int dpWay(int[] weights, int[] values, int bag) {
        int N = weights.length;
        int[][] dp = new int[N + 1][bag + 1];

        for (int i = N - 1; i >= 0; i--) {
            for (int rest = 1; rest <= bag; rest++) {
                int p1 = dp[i + 1][rest];
                if (rest >= weights[i]) {
                    dp[i][rest] = Math.max(p1, dp[i + 1][rest - weights[i]]+values[i]);
                } else {
                    dp[i][rest] = p1;
                }
            }
        }


        return dp[0][bag];
    }


}
