package arithmetic.zuo.class201;

public class Test {

    public static int needStep(int x, int y, int k) {
        return f(x, y, k);
    }

    private static int f(int x, int y, int k) {
        //基础情况
        if (k == 0) {
            return x == 0 && y == 0 ? 1 : 0;
        }
        //边界情况
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        return f(x - 1, y - 2, k - 1) + f(x + 1, y - 2, k - 1) + f(x + 2, y - 1, k - 1) + f(x + 2, y + 1, k - 1)
                + f(x + 1, y + 2, k - 1) + f(x - 1, y + 2, k - 1) + f(x - 2, y - 1, k - 1) + f(x - 2, y + 1, k - 1);
    }

    private static int dp(int x, int y, int k) {
        int[][][] dp = new int[10][9][k + 1];
        dp[0][0][0] = 1;

        for (int level = 1; level <= k; level++) {

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 9; j++) {
                    dp[i][j][level] = getValue(dp, i - 1, j - 2, level - 1) + getValue(dp, i + 1, j - 2, level - 1)
                            + getValue(dp, i + 2, j - 1, level - 1) + getValue(dp, i + 2, j + 1, level- 1)
                            + getValue(dp, i + 1, j + 2, level - 1) + getValue(dp, i - 1, j + 2, level - 1) +
                            getValue(dp, i - 2, j - 1, level- 1) + getValue(dp, i - 2, j + 1, level - 1);

/**
 *
 *                            getValue(dp, i + 2, j - 1, level - 1) + getValue(dp, i + 2, j + 1, level - 1)
 * 							+ getValue(dp, i + 1, j + 2, level - 1) + getValue(dp, i - 1, j + 2, level - 1)
 * 							+ getValue(dp, i - 2, j + 1, level - 1) + getValue(dp, i - 2, j - 1, level - 1)
 * 							+ getValue(dp, i - 1, j - 2, level - 1) + getValue(dp, i + 1, j - 2, level - 1);
 */
                }
            }
        }
        return dp[x][y][k];
    }

    public static int getValue(int[][][] dp, int x, int y, int k) {
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        return dp[x][y][k];
    }

    public static void main(String[] args) {
        System.out.println(needStep(6, 8, 10));
        System.out.println(dp(6, 8, 10));
    }
}
