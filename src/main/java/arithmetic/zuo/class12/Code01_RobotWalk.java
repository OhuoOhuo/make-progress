package arithmetic.zuo.class12;

/**
 * 总共N个位置，从M点出发，终点为P，K步，
 * 每次一步，到第一个位置，下一步只能到2，到N点，下一步只能到n-1
 */
public class Code01_RobotWalk {


    public static int ways1(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        return process(N, M, K, P);
    }

    public static int process(int N, int cur, int rest, int P) {
        if (rest == 0) {
            return cur == P ? 1 : 0;
        }
        if (cur == 1) {
            return process(N, 2, rest - 1, P);
        }
        if (cur == N) {
            return process(N, N - 1, rest - 1, P);
        }
        return process(N, cur - 1, rest - 1, P) + process(N, cur + 1, rest - 1, P);
    }

    //暴力修改法
    public static int waysCache(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        int[][] dp = new int[N + 1][K + 1];
        for (int row = 0; row < N + 1; row++) {
            for (int col = 0; col < K + 1; col++) {
                dp[row][col] = -1;
            }
        }
        return processCache(N, M, K, P, dp);
    }

    private static int processCache(int N, int cur, int rest, int P, int[][] dp) {

        if (rest == 0) {
            dp[cur][rest] = cur == P ? 1 : 0;
            return dp[cur][rest];
        }
        if (cur == 1) {
            dp[cur][rest] = process(N, 2, rest - 1, P);
            return dp[cur][rest];
        }
        if (cur == N) {
            dp[cur][rest] = process(N, N - 1, rest - 1, P);
            return dp[cur][rest];
        }
        dp[cur][rest] = processCache(N, cur - 1, rest - 1, P, dp) + processCache(N, cur + 1, rest - 1, P, dp);
        return dp[cur][rest];
    }

    public static void main(String[] args) {
        System.out.println(ways1(7, 4, 9, 5));
        System.out.println(waysCache(7, 4, 9, 5));
        System.out.println(ways2(7, 4, 9, 5));
    }

    private static int ways2(int N, int M, int K, int P) {
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        int[][] dp = new int[N + 1][K + 1];
        /*  if (rest == 0) {
            return cur == P ? 1 : 0;
        }*/
        dp[P][0] = 1;
        /*if (cur == 1) {
            return process(N, 2, rest - 1, P);
        }
        if (cur == N) {
            return process(N, N - 1, rest - 1, P);
        }
        return process(N, cur - 1, rest - 1, P) + process(N, cur + 1, rest - 1, P);*/
        for (int col = 1; col < K+1 ; col++) {
            for (int row = 1; row <N+1  ; row++) {
                if(row ==1){
                    dp[row][col] = dp[2][col-1];
                }else if(row == N){
                    dp[row][col] = dp[N-1][col-1];
                }else {
                    dp[row][col] = dp[row-1][col-1]+dp[row+1][col-1];
                }
            }
        }
        /**
         * 注意！！！！要根据最初的初始base case 来判断dp表是需要怎么循环
         */

/*        for (int row = 1; row <N+1  ; row++) {
            for (int col = 1; col < K+1 ; col++) {
               if(row ==1){
                    dp[row][col] = dp[2][col-1];
                }else if(row == N){
                    dp[row][col] = dp[N-1][col-1];
                }else {
                   dp[row][col] = dp[row-1][col-1]+dp[row+1][col-1];
               }
            }
        }*/
        return dp[M][K];
    }
}
