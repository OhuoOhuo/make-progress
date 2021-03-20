package arithmetic.zuo.class09;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 完成项目
 * <p>
 * 项目有成本，作为有受益，每次只能同时做一个，求做k个项目的最大值
 *
 * 一个小根堆记录成本，一个大根堆记录 受益
 * 每次都做在允许范围内获利最大的（贪心）
 */
public class Code05_IPO {


    public static class Program {
        public int p;
        public int c;

        public Program(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }


    /**
     * @param K       完成项目数量
     * @param W       初始资金
     * @param Profits 成本数组
     * @param Capital 利润数组
     * @return
     */
    public static int findMaximizedCapital(int K, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Program> minCapQ = new PriorityQueue<>(new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                return o1.c - o2.c;
            }
        });//资金组成小根堆
        PriorityQueue<Program> maxProQ = new PriorityQueue<>(new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                return o2.p - o1.p;
            }
        });//受益组成大根堆

        for (int i = 0; i < Profits.length; i++) {
            minCapQ.add(new Program(Profits[i], Capital[i]));
        }

        for (int i = 0; i < K; i++) {
            while (!minCapQ.isEmpty() && minCapQ.peek().c < W) {
                maxProQ.add(minCapQ.poll());
            }

            if (maxProQ.isEmpty()) {
                return W;
            }
            Program poll = maxProQ.poll();
            W += poll.p;
        }
        return W;

    }
}
