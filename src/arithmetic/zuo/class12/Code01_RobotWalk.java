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

        return process(N,M,K,P);
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
}
