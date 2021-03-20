package arithmetic.zuo.class207;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给一些线段，判断线段重合最多的次数
 */
public class Code01_CoverMax {

    //暴力方法,找到一个中点 （min+0.5）
    public static int maxCover1(int[][] lines) {
        //找到给定线段的最大最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lines.length; i++) {
            max = Math.max(max, lines[i][1]);
            min = Math.min(min, lines[i][0]);
        }
        int ans = 0;
        for (double i = min + 0.5; i < max; i = i + 1) {

            int cover = 0;
            for (int j = 0; j < lines.length; j++) {
                if (lines[j][0] < i && lines[j][1] > i) {
                    cover++;
                }
            }
            ans = Math.max(ans, cover);
        }
        return ans;
    }

    public static int maxCover2(int[][] m) {
        Line[] lines = new Line[m.length];
        for (int i = 0; i < m.length; i++) {
            lines[i] = new Line(m[i][0], m[i][1]);
        }
        Arrays.sort(lines, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Line> heap = new PriorityQueue<>(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.end - o2.end;
            }
        });
        int ans = 0;
        for (int i = 0; i < lines.length; i++) {
            while (!heap.isEmpty() && heap.peek().end <= lines[i].start) {
                heap.poll();
            }
            heap.add(lines[i]);
            ans = Math.max(ans, heap.size());
        }
        return ans;
    }

    public static class Line {
        public int start;
        public int end;

        public Line(int s, int e) {
            start = s;
            end = e;
        }
    }


    // for test
    public static int[][] generateLines(int N, int L, int R) {
        int size = (int) (Math.random() * N) + 1;
        int[][] ans = new int[size][2];
        for (int i = 0; i < size; i++) {
            int a = L + (int) (Math.random() * (R - L + 1));
            int b = L + (int) (Math.random() * (R - L + 1));
            if (a == b) {
                b = a + 1;
            }
            ans[i][0] = Math.min(a, b);
            ans[i][1] = Math.max(a, b);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        int N = 100;
        int L = 0;
        int R = 200;
        int testTimes = 200000;
        for (int i = 0; i < testTimes; i++) {
            int[][] lines = generateLines(N, L, R);
            int ans1 = maxCover1(lines);
            int ans2 = maxCover2(lines);
            if (ans1 != ans2) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test end");
    }
}
